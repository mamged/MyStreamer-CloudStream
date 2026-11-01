package com.mystreamer.cimalight

import com.lagradost.cloudstream3.TvType

// MyStreamer port — CimaLight
// Original primary domain: https://e.cimalight.co
// Alternate domains: https://cimalight.co
// 
class Cimalight : MyStreamerBase(
    providerName = "CimaLight",
    providerUrl = "https://e.cimalight.co",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
