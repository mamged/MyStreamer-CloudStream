package com.mystreamer.lodynet

import com.lagradost.cloudstream3.TvType

// MyStreamer port — LodyNet
// Original primary domain: https://lodynet.top
// No alternate domain recovered.
// 
class Lodynet : MyStreamerBase(
    providerName = "LodyNet",
    providerUrl = "https://lodynet.top",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
