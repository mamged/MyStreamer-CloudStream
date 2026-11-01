package com.mystreamer.akwam

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Akwam
// Original primary domain: https://akwam.ss
// No alternate domain recovered.
// 
class Akwam : MyStreamerBase(
    providerName = "Akwam",
    providerUrl = "https://akwam.ss",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
