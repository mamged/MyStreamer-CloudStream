package com.mystreamer.syrialive

import com.lagradost.cloudstream3.TvType

// MyStreamer port — SyriaLive
// Original primary domain: https://syrialive.boats
// No alternate domain recovered.
// Live sports provider.
class Syrialive : MyStreamerBase(
    providerName = "SyriaLive",
    providerUrl = "https://syrialive.boats",
    providerTypes = setOf(TvType.Live),
    searchPath = "/?s=",
    mainPages = listOf(),
)
