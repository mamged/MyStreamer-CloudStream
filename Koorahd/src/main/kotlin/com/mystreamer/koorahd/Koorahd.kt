package com.mystreamer.koorahd

import com.lagradost.cloudstream3.TvType

// MyStreamer port — KooraHD
// Original primary domain: https://alkora.club
// No alternate domain recovered.
// Live sports provider.
class Koorahd : MyStreamerBase(
    providerName = "KooraHD",
    providerUrl = "https://alkora.club",
    providerTypes = setOf(TvType.Live),
    searchPath = "/?s=",
    mainPages = listOf(),
)
