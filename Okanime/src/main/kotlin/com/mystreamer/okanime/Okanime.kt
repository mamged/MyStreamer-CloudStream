package com.mystreamer.okanime

import com.lagradost.cloudstream3.TvType

// MyStreamer port — OkAnime
// Original primary domain: https://ww3.okanime.xyz
// Alternate domains: https://okanime.xyz
// Anime provider.
class Okanime : MyStreamerBase(
    providerName = "OkAnime",
    providerUrl = "https://ww3.okanime.xyz",
    providerTypes = setOf(TvType.Anime),
    searchPath = "/?s=",
    mainPages = listOf("Anime List" to "/anime-list"),
)
