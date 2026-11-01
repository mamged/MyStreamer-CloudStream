package com.mystreamer.aflam

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Aflam
// Original primary domain: https://aflam.top
// No alternate domain recovered.
// 
class Aflam : MyStreamerBase(
    providerName = "Aflam",
    providerUrl = "https://aflam.top",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
