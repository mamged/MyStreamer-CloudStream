package com.mystreamer.kooraweb

import com.lagradost.cloudstream3.TvType

// MyStreamer port — KooraWeb
// Original primary domain: https://kooralovers.com
// No alternate domain recovered.
// Live sports provider.
class Kooraweb : MyStreamerBase(
    providerName = "KooraWeb",
    providerUrl = "https://kooralovers.com",
    providerTypes = setOf(TvType.Live),
    searchPath = "/?s=",
    mainPages = listOf(),
)
