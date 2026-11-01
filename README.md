# MyStreamer — CloudStream repo

A CloudStream extension repo ported from **MyStreamer**, the Enigma2 plugin by MNASR
([popking159/MyStreamer](https://github.com/popking159/MyStreamer), v1.0.3).

It contains **42 providers** — every provider module found in the v1.0.3 IPK
(`enigma2-plugin-extensions-mystreamer_1.0.3_aarch64_py3.13.ipk` on GitLab),
each as its own CloudStream plugin module that builds to its own `.cs3` file.

## Important, honest note

The GitHub repo only contains an installer script (`myinstaller.sh`); the plugin
itself is a compiled IPK, and every provider inside it is a compiled Cython
`.so` file — there is no Python source to copy line-for-line. So this repo is
**not a decompile**. What was recovered, honestly, from the IPK strings is:

- the provider list (42 modules, plus a shared `base` and a `urlparser` helper),
- each provider's primary domain and alternate domains,
- its search URL pattern (e.g. `/?s=`, `/search.php?keywords=`, `/search?s=`),
- and, where visible, its category paths (CimaNow, MySeed, MovieGate, Esheeq, …).

Each CloudStream provider reuses those recovered facts and a shared generic
scraper (`MyStreamerBase.kt`, copied into every module so each `.cs3` is
standalone): home page cards, search, load (movie / series episodes / live),
and link extraction (iframes, direct `.m3u8`/`.mp4` links in the page, and
CloudStream's `loadExtractor` for known video hosts — the equivalent of the
original `urlparser`).

That means: **domains and selectors will drift**. These sites change domains
and layouts often. If a provider shows empty lists, check `providers.json`
for its current domain, update `mainUrl` in its `<Provider>.kt`, and tune
`parseCards()` / `loadLinks()` for that one site. Do not expect a 1:1 copy of
the Enigma2 behaviour (favourites, downloads, Enigma2 UI, sports proxy in
TvSiir, Rotana/Roya live-ticket APIs) — those are Enigma2-only or need a
per-channel resolver, and are noted per-provider in `providers.json`.

## Providers

| Provider | Module | Primary domain | Types |
|---|---|---|---|
| Aflam | `Aflam` | https://aflam.top | Movie, TvSeries |
| AflamFree | `Aflamfree` | https://aflamfree.one | Movie, TvSeries |
| AhwakTV | `Ahwaktv` | https://ahwaktv.net | Movie, TvSeries |
| Akwam | `Akwam` | https://akwam.ss | Movie, TvSeries |
| AnimeZid | `Animezid` | https://animezid.org | Anime |
| AsTvD | `Astvd` | https://astvd.com | Movie, TvSeries |
| Brstej | `Brstej` | https://brsteej.lol | Movie, TvSeries |
| CimaLight | `Cimalight` | https://cimalight.co | Movie, TvSeries |
| CimaLina | `Cimalina` | https://tv.cemalen.shop | Movie, TvSeries |
| CimaNow | `Cimanow` | https://cimanow.cc | Movie, TvSeries |
| CimaWbs | `Cimawbs` | https://cimawbs.best | Movie, TvSeries |
| EgyBests | `Egybests` | https://egybests.live | Movie, TvSeries |
| EgyDead | `Egydead` | https://egydead.wiki | Movie, TvSeries |
| EgyNow | `Egynow` | https://www.egynow.buzz | Live |
| Esheeq | `Esheeq` | https://esheeq.study | TvSeries, Movie |
| FiveTV | `Fivetv` | https://5tv.asia | Movie, TvSeries, Anime |
| Fushaar | `Fushaar` | https://fussshaar.rest | Movie, TvSeries |
| GetKoora | `Getkoora` | https://getkoora.quest | Live |
| HwanaTurkya | `Hwnaturkya` | https://www.hwnaturkya.com | TvSeries, Movie |
| KooraHD | `Koorahd` | https://koorahd.net | Live |
| KooraWeb | `Kooraweb` | https://kooraweb.com | Live |
| Krmzy | `Krmzy` | https://krmzy.org | Movie, TvSeries |
| Larooza | `Larooza` | https://larooza.motorcycles | Movie, TvSeries |
| LodyNet | `Lodynet` | https://lodynet.watch | Movie, TvSeries |
| MovieGate | `Moviegate` | https://moviegate.one | Movie |
| MovizLand | `Movizland` | https://www.moviz.land | Movie, TvSeries |
| MyCima | `Mycima` | https://cima.my-cima.net | Movie, TvSeries |
| MySeed | `Myseed` | https://m.myseed.tv | Movie, TvSeries |
| MyWecima | `Mywecima` | https://mywecima.work | Movie, TvSeries |
| OkAnime | `Okanime` | https://okanime.xyz | Anime |
| OldAkwam | `Oldakwam` | https://old.akwam.ss | Movie, TvSeries |
| QFilm | `Qfilm` | https://qfilm.tv | Movie, TvSeries |
| Rotana | `Rotana` | https://rotana.net | Live |
| Roya | `Roya` | https://roya.tv | Live |
| Shaahid4U | `Shaahid4u` | https://shaahidd4u.net | Movie, TvSeries |
| ShahiidAnime | `Shahiidanime` | https://shahiid-anime.net | Anime |
| ShoofLive | `Shooflive` | https://shooflive.watch | Movie, TvSeries |
| SyriaLive | `Syrialive` | https://syrialive.lol | Live |
| TukCima | `Tukcima` | https://tukcima.com | Movie, TvSeries |
| TvSiir | `Tvsiir` | https://tvsiir.co | Live |
| TxCima | `Txcima` | https://b.txcima.com | Movie, TvSeries |
| Zaflam | `Zaflam` | https://zaflam.com | Movie, TvSeries |

Full machine-readable list (including alternate domains, search paths and
category paths): [`providers.json`](providers.json).
Original provider icons recovered from the IPK: [`icons/`](icons/).

## Build

This follows the official
[recloudstream/TestPlugins](https://github.com/recloudstream/TestPlugins)
template (root `build.gradle.kts`, Gradle wrapper, per-module
`build.gradle.kts`). You need JDK 17 + Android SDK.

```bash
# all providers
./gradlew make makePluginsJson
# one provider, e.g. EgyDead
./gradlew Egydead:make
```

Compiled `.cs3` files land in each module's `build/` directory.

## Publish / install in CloudStream (GitHub Actions)

1. Push this repo to GitHub (suggested name: `MyStreamer-CloudStream`).
2. Create an empty `builds` branch in that repo — the included
   `.github/workflows/build.yml` (from the template) builds on every push to
   `main`/`master` and force-pushes the `.cs3` files + `plugins.json` to
   `builds`.
3. In CloudStream: Settings → Extensions → Add repository, and paste:

```
https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/builds/plugins.json
```

This repo is `mamged/MyStreamer-CloudStream`; replace that with your own `user/repo` if you fork it. The Gradle plugin picks up `GITHUB_REPOSITORY` automatically on CI;
the fallback in the root `build.gradle.kts` is only for local builds.

## Structure

```
build.gradle.kts          # template root build, repo = mamged/MyStreamer-CloudStream
settings.gradle.kts       # auto-includes every folder with a build.gradle.kts
gradlew / gradle/         # Gradle wrapper from the template
Aflam/                    # one folder per provider
  build.gradle.kts        # version, authors, tvTypes, language=ar, iconUrl
  src/main/AndroidManifest.xml
  src/main/kotlin/com/mystreamer/aflam/
    Aflam.kt              # name / mainUrl / types / searchPath / categories
    AflamPlugin.kt        # @CloudstreamPlugin, registerMainAPI(...)
    MyStreamerBase.kt     # shared generic scraper (copied per module)
icons/                    # original provider icons from the IPK
providers.json            # auditable provider manifest
```

## Compatibility / testing (v2)

`MyStreamerBase.kt` was re-checked against the current CloudStream
pre-release API (`recloudstream/cloudstream`, `library/MainAPI.kt` and
`library/utils/ExtractorApi.kt`) and fixed where v1 would not compile or
would not show in the app:

- Homepage categories now come from `mainPage` (`mainPageOf`) and
  `getMainPage(page, request)` honours `request.data`, with pagination as
  `<path>/page/<n>/` and `hasNext` based on whether cards were actually
  returned — v1 ignored `request.data`.
- No direct construction of `SearchResponse` / `LoadResponse` / `Episode` /
  `ExtractorLink` / `SubtitleFile` (all `@Deprecated(ERROR)` now). Only the
  `new*` helpers are used: `newMovie/TvSeries/Anime/LiveStreamLoadResponse`,
  `newEpisode`, `newExtractorLink`, `newSubtitleFile`. There is no
  `newLiveLoadResponse`; live uses `newLiveStreamLoadResponse`.
- Requests use `app.get(url, referer = mainUrl).text` parsed with Jsoup
  (the parser the template ships), not `app.get().document`, whose type
  changed to Ksoup in newer pre-release builds.
- Search pagination: WordPress `/?s=` paginates as `/page/<n>/?s=`; other
  search endpoints return no page 2 instead of duplicating page 1.
- Data flow is always a plain page URL: search/main-page URL ->
  `load(url)` -> `dataUrl` / `Episode.data` -> `loadLinks(data)`, so links
  survive an app restart. `loadLinks` follows one same-site embed level,
  extracts direct `.m3u8`/`.mp4`/`.mpd` links, delegates other hosts to
  `loadExtractor`, and registers `.srt`/`.vtt` subtitles.
- `load()` only takes a year from a year/date element or the plot, never
  from whole-page text (v1 picked up footer years), and episodes are
  de-duplicated, numbered, and reversed if a site lists them newest-first.

See `TESTING.md` for the live crawl results and what still needs a
device-side check in the CloudStream app itself.

## Licence / attribution

Original plugin: MNASR / popking159 (GPL-2.0 in the IPK control file).
Template: recloudstream/TestPlugins. This port keeps the original author
credit in every module's `build.gradle.kts`.
