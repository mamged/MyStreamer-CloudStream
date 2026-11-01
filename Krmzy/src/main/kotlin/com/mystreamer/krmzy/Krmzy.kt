package com.mystreamer.krmzy

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Krmzy
// Original primary domain: https://krmzy.org
// No alternate domain recovered.
// 
class Krmzy : MyStreamerBase(
    providerName = "Krmzy",
    providerUrl = "https://krmzy.org",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf("Series" to "/series/"),
)
