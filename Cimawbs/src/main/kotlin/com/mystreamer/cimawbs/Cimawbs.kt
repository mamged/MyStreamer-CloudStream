package com.mystreamer.cimawbs

import com.lagradost.cloudstream3.TvType

// MyStreamer port — CimaWbs
// Original primary domain: https://cimawbas.rest
// No alternate domain recovered.
// 
class Cimawbs : MyStreamerBase(
    providerName = "CimaWbs",
    providerUrl = "https://cimawbas.rest",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
