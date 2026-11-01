package com.mystreamer.qfilm

import com.lagradost.cloudstream3.TvType

// MyStreamer port — QFilm
// Original primary domain: https://qfilm.tv
// Alternate domains: https://a.qfilm.tv
// 
class Qfilm : MyStreamerBase(
    providerName = "QFilm",
    providerUrl = "https://qfilm.tv",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/search.php?keywords=",
    mainPages = listOf(),
)
