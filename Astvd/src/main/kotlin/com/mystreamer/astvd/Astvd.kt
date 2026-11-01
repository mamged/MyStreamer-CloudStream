package com.mystreamer.astvd

import com.lagradost.cloudstream3.TvType

// MyStreamer port — AsTvD
// Original primary domain: https://astvd.com
// Alternate domains: https://asiawiki.me/
// 
class Astvd : MyStreamerBase(
    providerName = "AsTvD",
    providerUrl = "https://astvd.com",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
