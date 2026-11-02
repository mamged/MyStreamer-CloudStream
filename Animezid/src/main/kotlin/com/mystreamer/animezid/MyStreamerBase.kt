package com.mystreamer.animezid

import com.lagradost.cloudstream3.DubStatus
import com.lagradost.cloudstream3.Episode
import com.lagradost.cloudstream3.HomePageList
import com.lagradost.cloudstream3.HomePageResponse
import com.lagradost.cloudstream3.LoadResponse
import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.MainPageData
import com.lagradost.cloudstream3.MainPageRequest
import com.lagradost.cloudstream3.SearchResponse
import com.lagradost.cloudstream3.SubtitleFile
import com.lagradost.cloudstream3.TvType
import com.lagradost.cloudstream3.addQuality
import com.lagradost.cloudstream3.app
import com.lagradost.cloudstream3.fixUrl
import com.lagradost.cloudstream3.mainPageOf
import com.lagradost.cloudstream3.newAnimeLoadResponse
import com.lagradost.cloudstream3.newAnimeSearchResponse
import com.lagradost.cloudstream3.newEpisode
import com.lagradost.cloudstream3.newHomePageResponse
import com.lagradost.cloudstream3.newLiveSearchResponse
import com.lagradost.cloudstream3.newLiveStreamLoadResponse
import com.lagradost.cloudstream3.newMovieLoadResponse
import com.lagradost.cloudstream3.newMovieSearchResponse
import com.lagradost.cloudstream3.newSearchResponseList
import com.lagradost.cloudstream3.newTvSeriesLoadResponse
import com.lagradost.cloudstream3.newTvSeriesSearchResponse
import com.lagradost.cloudstream3.utils.ExtractorLink
import com.lagradost.cloudstream3.utils.ExtractorLinkType
import com.lagradost.cloudstream3.utils.Qualities
import com.lagradost.cloudstream3.utils.getQualityFromName
import com.lagradost.cloudstream3.utils.loadExtractor
import com.lagradost.cloudstream3.utils.newExtractorLink
import com.lagradost.cloudstream3.newSubtitleFile
import java.net.URLEncoder
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Generic MyStreamer base, v2 — fixed against the current CloudStream
 * pre-release API (recloudstream/cloudstream, library/MainAPI.kt).
 *
 * Compatibility notes, all verified against that source (not the old template):
 * - Homepage categories MUST come from [mainPage] and [getMainPage] MUST honour
 *   [MainPageRequest.data]. The app calls getMainPage once per mainPage entry;
 *   ignoring request.data (v1 bug) showed every category under one tab and
 *   broke pagination. v2 maps mainPages -> mainPageOf(path to label) and
 *   fetches exactly request.data, paginated as <path>/page/<n>/.
 * - Never construct SearchResponse / LoadResponse / Episode / ExtractorLink /
 *   SubtitleFile directly: their constructors are @Deprecated(ERROR) in the
 *   current API. v2 uses only newMovie/TvSeries/Anime/LiveSearchResponse,
 *   newMovie/TvSeries/Anime/LiveStreamLoadResponse, newEpisode,
 *   newExtractorLink and newSubtitleFile.
 * - There is no newLiveLoadResponse; the live helper is
 *   newLiveStreamLoadResponse(name, url, dataUrl).
 * - newAnimeLoadResponse has NO dataUrl parameter; anime episodes live in
 *   episodes[DubStatus] inside the initializer.
 * - Requests go through app.get(url, referer = mainUrl).text and are parsed
 *   with Jsoup (the parser the template ships as an implementation dependency).
 *   This deliberately avoids app.get().document, whose type changed from
 *   Jsoup to Ksoup in newer pre-release builds.
 * - Data flow, end to end: parseCards -> SearchResponse.url (fixUrl makes it
 *   absolute) -> load(url) -> LoadResponse.dataUrl / Episode.data (a plain
 *   watch-page URL) -> loadLinks(data) -> ExtractorLink / loadExtractor.
 *   No JSON is invented anywhere; data is always the page URL itself, so
 *   loadLinks can re-fetch it even after an app restart.
 *
 * The original Enigma2 providers are compiled Cython .so files, so this is
 * still not a decompile: names, domains, search patterns and category paths
 * are recovered from v1.0.3, selectors are generic on purpose.
 */
abstract class MyStreamerBase(
    providerName: String,
    providerUrl: String,
    providerTypes: Set<TvType>,
    private val searchPath: String,
    protected val mainPages: List<Pair<String, String>>,
) : MainAPI() {
    override var name = providerName
    override var mainUrl = providerUrl.trimEnd('/')
    override val supportedTypes = providerTypes
    override var lang = "ar"
    override val hasMainPage = true

    // Serialize homepage requests: these sites rate-limit / Cloudflare-block
    // bursts of parallel category requests from one device.
    override var sequentialMainPage = true

    override val mainPage: List<MainPageData>
        get() = if (mainPages.isEmpty()) {
            listOf(MainPageData("Latest", ""))
        } else {
            mainPageOf(*mainPages.map { (label, path) -> path to label }.toTypedArray())
        }

    private fun isType(t: TvType) = supportedTypes.contains(t)

    private suspend fun fetchDocument(url: String): Document {
        // text + Jsoup.parse(baseUri) gives correct abs:href on every build.
        val text = app.get(url, referer = mainUrl).text
        return Jsoup.parse(text, url)
    }

    private fun isCloudflare(doc: Document): Boolean {
        val title = doc.title().lowercase()
        return title.contains("just a moment") || title.contains("attention required") ||
            doc.text().contains("cf-challenge", ignoreCase = true)
    }

    private fun cleanTitle(raw: String): String {
        return raw.replace(Regex("\\s+"), " ").trim()
            .removePrefix("مشاهدة ").removePrefix("مشاهدة فيلم ").removePrefix("مسلسل ")
            .trim()
    }

    private fun posterOf(a: org.jsoup.nodes.Element): String? {
        val img = a.selectFirst("img")
        if (img != null) {
            for (attr in listOf("src", "data-src", "data-lazy-src", "data-original")) {
                val v = img.attr("abs:$attr").trim()
                if (v.isNotBlank() && !v.contains("placeholder", ignoreCase = true) &&
                    !v.endsWith(".gif") && !v.contains("grey.gif", ignoreCase = true)) return v
            }
            val srcset = img.attr("abs:srcset").trim()
            if (srcset.isNotBlank()) {
                val first = srcset.split(",").firstOrNull()?.trim()?.split(" ")?.firstOrNull()
                if (!first.isNullOrBlank()) return first
            }
        }
        // Some sites paint cards with a background-image instead of an <img>.
        val bg = a.selectFirst("[style*=background]")?.attr("style")
            ?: a.attr("style")
        if (!bg.isNullOrBlank()) {
            val m = Regex("url\\(['\"]?(.*?)['\"]?\\)").find(bg)?.groupValues?.get(1)
            if (!m.isNullOrBlank()) return fixUrl(m)
        }
        return null
    }

    private fun searchResponse(title: String, url: String, poster: String?, cardText: String): SearchResponse {
        val quality = Regex("(2160|1080|720|480|360)p", RegexOption.IGNORE_CASE).find(cardText)?.value
        val resp: SearchResponse = when {
            isType(TvType.Anime) -> newAnimeSearchResponse(title, url, TvType.Anime) { this.posterUrl = poster }
            isType(TvType.Live) -> newLiveSearchResponse(title, url, TvType.Live) { this.posterUrl = poster }
            title.contains("مسلسل") || url.contains("/series") || url.contains("مسلسل") ||
                url.contains("/season") -> newTvSeriesSearchResponse(title, url, TvType.TvSeries) { this.posterUrl = poster }
            else -> newMovieSearchResponse(title, url, TvType.Movie) { this.posterUrl = poster }
        }
        if (quality != null) resp.addQuality(quality)
        return resp
    }

    /** Generic card parser. Returns only same-host content links with a title. */
    fun parseCards(doc: Document): List<SearchResponse> {
        if (isCloudflare(doc)) return emptyList()
        val host = try { java.net.URL(mainUrl).host } catch (_: Exception) { "" }
        // Prefer real content grids; fall back to every link only if none found.
        val gridLinks = doc.select("article a[href], .post a[href], .item a[href], .movie a[href], .card a[href], .box a[href], .content a[href]")
        val links = if (gridLinks.isNotEmpty()) gridLinks else doc.select("a[href]")
        val seen = mutableSetOf<String>()
        val out = mutableListOf<SearchResponse>()
        val navWords = setOf("الرئيسية", "home", "اتصل بنا", "contact", "سياسة الخصوصية", "privacy", "dmca", "تسجيل الدخول", "login", "المضاف حديثا", "جديد الموقع", "الصفحة الرئيسية", "قائمة الأنمي", "دخول الموقع", "مباريات اليوم", "مباريات الأمس", "مباريات الغد")
        val listingPaths = setOf("/last", "/last/", "/recent", "/recent/", "/main", "/main/", "/home", "/home/", "/index.php", "/movies", "/movies/", "/series", "/series/", "/main31", "/main31/")
        for (a in links) {
            val href = a.attr("abs:href").trim()
            if (href.isBlank() || !seen.add(href)) continue
            if (host.isNotBlank()) {
                val h = try { java.net.URL(href).host } catch (_: Exception) { "" }
                // Exact host after stripping www. only. Subdomain-both-ways
                // (v2) leaked logo links like my-cima.net on cima.my-cima.net,
                // and a strict check is correct now that mainUrl itself is
                // updated to the site's current redirect target (see
                // providers.json). Users can override mainUrl in the app
                // if a site moves again (canBeOverridden is true).
                val norm = { s: String -> s.removePrefix("www.") }
                if (h.isNotBlank() && norm(h) != norm(host)) continue
            }
            if (href == mainUrl || href == "$mainUrl/") continue
            if (href.contains("/category/") || href.contains("/tag/") || href.contains("/author/") ||
                href.contains("/genre/") || href.contains("genre") || href.contains("/page/") || href.contains("?s=") ||
                href.contains("/search")) continue
            val img = a.selectFirst("img")
            var title = cleanTitle(img?.attr("alt").orEmpty())
            if (title.isBlank()) title = cleanTitle(a.text())
            if (title.isBlank() || title.length < 2 || title.length > 160) continue
            if (navWords.any { title.equals(it, ignoreCase = true) }) continue
            // Listing / section pages are not content: /last, /recent, /main,
            // /home, /movies, /series and /year/<...> are category pages, and
            // a card with no poster is almost always a nav/logo link (v1
            // included those as fake movies — e.g. "المضاف حديثا" -> /last/).
            val path = try { java.net.URL(href).path } catch (_: Exception) { "" }
            if (path in listingPaths || path.startsWith("/year/")) continue
            val poster = posterOf(a) ?: continue
            out.add(searchResponse(title, href, poster, a.text()))
            if (out.size >= 60) break
        }
        return out
    }

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val path = request.data.trim()
        val base = if (path.isBlank()) mainUrl else (mainUrl + "/" + path.trim('/'))
        val url = if (page <= 1) base else "$base/page/$page/"
        val cards = try { parseCards(fetchDocument(url)) } catch (_: Exception) { emptyList() }
        return newHomePageResponse(
            listOf(HomePageList(request.name.ifBlank { "Latest" }, cards)),
            hasNext = cards.isNotEmpty(),
        )
    }

    private suspend fun fetchSearch(query: String, page: Int): Pair<List<SearchResponse>, Boolean> {
        val q = URLEncoder.encode(query, "UTF-8")
        // WordPress-style search paginates as /page/N/?s=q; the php / query
        // search endpoints in this repo have no known pagination, so page>1
        // returns empty instead of duplicating page 1 (the old default did).
        val isWordpress = searchPath == "/?s="
        if (page > 1 && !isWordpress) return emptyList<SearchResponse>() to false
        val url = when {
            isWordpress && page > 1 -> "$mainUrl/page/$page/?s=$q"
            searchPath.contains("{q}") -> mainUrl + searchPath.replace("{q}", q)
            else -> mainUrl + searchPath + q
        }
        val cards = try { parseCards(fetchDocument(url)) } catch (_: Exception) { emptyList() }
        return cards to cards.isNotEmpty()
    }

    override suspend fun search(query: String): List<SearchResponse>? {
        return fetchSearch(query, 1).first
    }

    override suspend fun search(query: String, page: Int): com.lagradost.cloudstream3.SearchResponseList? {
        val (cards, hasNext) = fetchSearch(query, page)
        return newSearchResponseList(cards, hasNext)
    }

    override suspend fun load(url: String): LoadResponse? {
        val doc = try { fetchDocument(url) } catch (_: Exception) { return null }
        if (isCloudflare(doc)) return null
        val rawTitle = doc.selectFirst("meta[property=og:title]")?.attr("content")?.trim()
            ?: doc.selectFirst("h1")?.text()?.trim()
            ?: doc.title().trim()
        val title = cleanTitle(rawTitle)
        if (title.isBlank()) return null
        val poster = doc.selectFirst("meta[property=og:image]")?.attr("content")?.takeIf { it.isNotBlank() }
            ?: doc.selectFirst("article img, main img, .post img")?.attr("abs:src")?.takeIf { it.isNotBlank() }
        val plot = doc.selectFirst("meta[property=og:description]")?.attr("content")?.takeIf { it.isNotBlank() }
            ?: doc.selectFirst("meta[name=description]")?.attr("content")?.takeIf { it.isNotBlank() }
            ?: doc.selectFirst("article p, .post p")?.text()?.takeIf { it.length > 20 }
        // Year only from a year/date element or the plot — never from the
        // whole page text (that picked up copyright / footer years in v1).
        val yearText = doc.select(".year, [class*=year], [class*=date]").text() + " " + (plot ?: "")
        val year = Regex("(19|20)\\d{2}").find(yearText)?.value?.toIntOrNull()

        val season = Regex("الموسم\\s*(\\d+)|Season\\s*(\\d+)|S(\\d+)E", RegexOption.IGNORE_CASE)
            .find(title + " " + url)?.groupValues?.firstNotNullOfOrNull { it.toIntOrNull() }

        // Episode links: explicit episode containers first, then any link
        // whose text or href says episode / الحلقة.
        val epAnchors = linkedMapOf<String, org.jsoup.nodes.Element>()
        doc.select(".episodes a[href], .episode-list a[href], [class*=episode] a[href], [id*=episode] a[href]").forEach {
            epAnchors[it.attr("abs:href")] = it
        }
        doc.select("a[href]").forEach { a ->
            val h = a.attr("abs:href")
            val t = a.text()
            if (h.contains("/episode") || h.contains("episode-") || t.contains("الحلقة") || t.contains("Episode", ignoreCase = true)) {
                epAnchors[h] = a
            }
        }
        val episodeLinks = epAnchors.entries.filter { (h, _) ->
            h.isNotBlank() && h != url && !h.contains("/category/") && !h.contains("/tag/")
        }
        fun episodeNumber(text: String, href: String): Int? {
            return Regex("الحلقة\\s*(\\d+)|Episode\\s*(\\d+)|E(\\d+)$|-(\\d+)/?$", RegexOption.IGNORE_CASE)
                .find(text + " " + href)?.groupValues?.firstNotNullOfOrNull { it.toIntOrNull() }
        }
        val sortedEpisodes = episodeLinks.let { entries ->
            val nums = entries.map { episodeNumber(it.value.text(), it.key) }
            if (nums.all { it != null } && nums.zipWithNext().all { (a, b) -> a!! > b!! }) entries.reversed() else entries
        }
        val episodes: List<Episode> = sortedEpisodes.mapIndexed { i, (href, a) ->
            newEpisode(href, initializer = {
                this.name = cleanTitle(a.text()).ifBlank { "Episode ${episodeNumber(a.text(), href) ?: (i + 1)}" }
                this.episode = episodeNumber(a.text(), href) ?: (i + 1)
                this.season = season
                this.posterUrl = posterOf(a)
            })
        }

        return when {
            isType(TvType.Live) -> newLiveStreamLoadResponse(title, url, url) {
                this.posterUrl = poster; this.plot = plot
            }
            isType(TvType.Anime) -> newAnimeLoadResponse(title, url, TvType.Anime) {
                this.posterUrl = poster; this.plot = plot; this.year = year
                if (episodes.isNotEmpty()) {
                    this.episodes[DubStatus.Subbed] = episodes
                } else {
                    // A single playable entry so an anime movie is not
                    // marked comingSoon with zero episodes.
                    this.episodes[DubStatus.Subbed] = listOf(newEpisode(url, initializer = { this.name = title }))
                }
            }
            episodes.isNotEmpty() -> newTvSeriesLoadResponse(title, url, TvType.TvSeries, episodes) {
                this.posterUrl = poster; this.plot = plot; this.year = year
            }
            else -> newMovieLoadResponse(title, url, TvType.Movie, url) {
                this.posterUrl = poster; this.plot = plot; this.year = year
            }
        }
    }

    private fun directQuality(link: String): Int {
        val m = Regex("(2160|1080|720|480|360)").find(link)?.value
        return if (m != null) getQualityFromName(m) else Qualities.Unknown.value
    }

    private suspend fun emitDirect(
        link: String, referer: String, callback: (ExtractorLink) -> Unit,
    ): Boolean {
        val fixed = fixUrl(link)
        if (fixed.isBlank()) return false
        val type = when {
            fixed.contains(".m3u8") -> ExtractorLinkType.M3U8
            fixed.contains(".mpd") -> ExtractorLinkType.DASH
            else -> ExtractorLinkType.VIDEO
        }
        callback(newExtractorLink(source = name, name = name, url = fixed, type = type) {
            this.referer = referer
            this.quality = directQuality(fixed)
        })
        return true
    }

    /** Collect direct + iframe links from one page; optionally follow one
     *  same-site embed level (movie page -> server iframe -> stream page). */
    private suspend fun collectFromDoc(
        doc: Document, pageUrl: String, depth: Int,
        subtitleCallback: (SubtitleFile) -> Unit, callback: (ExtractorLink) -> Unit,
    ): Boolean {
        var found = false
        val html = doc.html()
        val candidates = linkedSetOf<String>()
        doc.select("iframe[src], iframe[data-src]").forEach {
            val s = it.attr("abs:src").ifBlank { it.attr("abs:data-src") }
            if (s.isNotBlank()) candidates.add(s)
        }
        doc.select("video source[src], source[src]").forEach { candidates.add(it.attr("abs:src")) }
        doc.select("a[href]").forEach {
            val h = it.attr("abs:href")
            if (h.contains(".m3u8") || h.contains(".mp4") || h.contains(".mpd") ||
                h.contains(".srt") || h.contains(".vtt")) candidates.add(h)
        }
        Regex("""https?://[^\s"'<>]+\.(?:m3u8|mp4|mpd)[^\s"'<>]*""").findAll(html).forEach { candidates.add(it.value) }
        // Subtitles first, so they are registered even if video extraction fails.
        for (link in candidates) {
            if (link.contains(".srt") || link.contains(".vtt")) {
                try {
                    subtitleCallback(newSubtitleFile(lang = "ar", url = fixUrl(link)))
                } catch (_: Exception) { }
            }
        }
        val blockedHosts = listOf("youtube.com", "youtu.be", "facebook.com", "twitter.com", "instagram.com", "whatsapp.com", "telegram.me", "t.me")
        for (raw in candidates) {
            if (raw.contains(".srt") || raw.contains(".vtt")) continue
            val link = fixUrl(raw)
            if (link.isBlank() || blockedHosts.any { link.contains(it) }) continue
            try {
                when {
                    link.contains(".m3u8") || link.contains(".mp4") || link.contains(".mpd") -> {
                        if (emitDirect(link, pageUrl, callback)) found = true
                    }
                    depth < 1 && link.startsWith(mainUrl) -> {
                        // Same-site embed / server page: follow it once.
                        try {
                            val inner = fetchDocument(link)
                            if (collectFromDoc(inner, link, depth + 1, subtitleCallback, callback)) found = true
                        } catch (_: Exception) { }
                    }
                    else -> {
                        if (loadExtractor(link, pageUrl, subtitleCallback, callback)) found = true
                    }
                }
            } catch (_: Exception) { }
        }
        return found
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ): Boolean {
        if (data.isBlank()) return false
        // data is always a plain page URL in this repo (see class doc), so a
        // direct stream stored as data is also handled here.
        if (data.contains(".m3u8") || data.endsWith(".mp4") || data.contains(".mpd")) {
            return emitDirect(data, mainUrl, callback)
        }
        val doc = try { fetchDocument(data) } catch (_: Exception) { return false }
        return collectFromDoc(doc, data, 0, subtitleCallback, callback)
    }
}
