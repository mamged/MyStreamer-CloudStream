# Testing

This file records what was actually checked, not what was hoped for.
It is updated after each test run; do not read it as a promise that
every provider works on a phone today.

## 1. API compatibility (static, against current CloudStream source)

Checked against `recloudstream/cloudstream` master:
`library/src/commonMain/kotlin/com/lagradost/cloudstream3/MainAPI.kt`
and `library/src/commonMain/kotlin/com/lagradost/cloudstream3/utils/ExtractorApi.kt`.

- `mainPage` / `getMainPage(page, request)` — request.data is honoured.
- `search(query)` and `search(query, page)` — page 2 does not duplicate page 1.
- `load(url)` — movie / series / anime / live branches use only the
  `new*LoadResponse` helpers.
- `loadLinks(data, isCasting, subtitleCallback, callback)` — data is a
  plain page URL, direct links use `newExtractorLink`, other hosts use
  `loadExtractor`, subtitles use `newSubtitleFile`.
- No direct `Episode(...)`, `ExtractorLink(...)` or `SubtitleFile(...)`
  construction (all `@Deprecated(ERROR)` in the current API).

## 2. Gradle build

Run: `./gradlew make makePluginsJson`
Result (2026-11-01, this sandbox): **NOT buildable here — environmental,
not a repo defect.** Every Gradle run fails with
`Could not receive a message from the daemon` / `DaemonConnectionException`
caused by `IllegalArgumentException: Unexpected type tag 109` reading the
daemon socket. This reproduces for a trivial `hello` project too, with the
daemon and `--no-daemon`, Temurin 17 and Ubuntu OpenJDK 17, and fresh
`GRADLE_USER_HOME` dirs, while raw localhost TCP works — so the failure
is in the sandbox/Gradle-daemon protocol, not in this repo. The GitHub
Actions workflow in this repo (`./gradlew make makePluginsJson`) is the
expected build route until a working Gradle environment is available.

Substitute verification, same day: **kotlinc 2.1.0 type-check of all 126
`.kt` files against hand-written stubs matching the verified real API
signatures (MainAPI.kt / ExtractorApi.kt) plus the real Jsoup 1.18.3 jar:
0 errors.** It caught two real bugs, both fixed in every module:
a missing `import com.lagradost.cloudstream3.addQuality`, and
`episodeLinks.entries` on a filtered `List<Map.Entry>` (now just
`episodeLinks`). The stub also confirmed `newEpisode(url) { ... }`
resolves to the generic `newEpisode(data: T, ...)` overload in the real
API, which is why that call shape is legal. This check does NOT cover
Android plugin / manifest merging / resource compilation — only a real
Gradle build (CI or a local machine) covers those.

## 3. Live crawl (Python mirror of MyStreamerBase.parseCards)

The crawl mirrors the Kotlin parser (www-stripped exact host match,
poster required, listing pages and genre links excluded, Cloudflare
detection) and fetches home (first mainPage) / search ("فيلم") / first
content page for every provider.

### Latest run — 2026-11-01, crawl v4 (42 providers, 42 s)

- Home cards > 0 (28): Aflam 47, Aflamfree 46, Akwam 1, Animezid 60,
  Cimalight 60, Cimalina 11, Cimanow 26, Cimawbs 59, Fivetv 24, Fushaar 60,
  Hwnaturkya 30, Koorahd 8, Kooraweb 40, Krmzy 40, Larooza 1, Moviegate 36,
  Movizland 60, Mycima 60, Myseed 40, Mywecima 60, Rotana 22, Shahiidanime
  60, Shaahid4u 60 (after the 2026-11-01 domain fix below), Shooflive 50,
  Syrialive 25, Tukcima 40, Tvsiir 11, Txcima 48, Zaflam 60.
- Search cards > 0 (28): the home-working set plus Brstej 15, Esheeq 50,
  Okanime 8 — their home pages return no cards under the generic
  selectors, but their search results parse fine, so the base parser
  works for them and only the home grid differs.
- Load spot-checks (first home card): episode links found for Akwam 48,
  Cimawbs 30, Fushaar 49, Hwnaturkya 55, Krmzy 36, Larooza 75, Mycima 22,
  Myseed 12, Mywecima 45, Shahiidanime 5; direct media found for
  Hwnaturkya 1, Myseed 4; iframes for Cimanow 1, Myseed 1, Shahiidanime 1,
  Shooflive 1. Many detail pages show 0 iframes because the watch page
  (not the detail page) holds the player — that is the page `loadLinks`
  follows, so 0 here is not a failure.
- Home 200 + cards = 0 (12): Ahwaktv, Brstej, Egybests, Egydead, Egynow,
  Esheeq, Getkoora, Lodynet, Okanime, Oldakwam, Qfilm, Roya.
  (Shaahid4u was in this group in crawl v4 only because its old domain
  redirected to a different host, which the exact-host filter correctly
  rejected; updating its mainUrl to https://shahid4us.com — verified
  2026-11-01, 60 home cards — moved it to the working group. That makes
  17 domain/mainPage updates in total.)
  Several are landing/redirect pages (Ahwaktv -> yam.ahwaktv.net,
  Brstej -> /home03, Egynow -> /event_1, Shaahid4u -> shahid4us.com,
  Egydead's root has ~1 image total) or JS-rendered grids — they need
  per-site selectors, not a repo-wide fix, and search still works for
  Brstej/Esheeq/Okanime.
- Sandbox proxy errors (NOT proof a site is down on a phone): Astvd
  (all requests), Rotana and Txcima detail pages (their home pages
  returned cards fine in the same run).

Interpretation rules, unchanged: home 200 + cards > 0 means homepage
parsing works in principle; home 200 + cards = 0 means the generic
selectors miss that site's grid; a timeout/proxy error in this sandbox
means nothing about the site on a real phone.

## 4. What still needs a device check

A Gradle `.cs3` build passing does NOT prove playback in the app.
On a phone with CloudStream (pre-release, since this uses the
pre-release API):

1. Add the repo, install one provider, open its home tab — each
   `mainPage` entry should show its own list, not the same list repeated.
2. Search, open a movie and a series, check episodes are numbered and
   in ascending order.
3. Play: a direct `.m3u8`/`.mp4` link should start, and an iframe host
   should resolve through `loadExtractor`. If a host shows "no links",
   that host needs its own extractor or a per-site resolver — the
   generic path cannot invent one.
4. Check a live/sports provider at match time; outside match windows
   many sports pages legitimately have no playable links.
