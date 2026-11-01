package com.mystreamer.zaflam

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Zaflam
// Original primary domain: https://zaflam.com
// No alternate domain recovered.
// 
class Zaflam : MyStreamerBase(
    providerName = "Zaflam",
    providerUrl = "https://zaflam.com",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
