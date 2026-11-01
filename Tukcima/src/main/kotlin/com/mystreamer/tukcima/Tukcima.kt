package com.mystreamer.tukcima

import com.lagradost.cloudstream3.TvType

// MyStreamer port — TukCima
// Original primary domain: https://tukcima.com
// No alternate domain recovered.
// 
class Tukcima : MyStreamerBase(
    providerName = "TukCima",
    providerUrl = "https://tukcima.com",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf("Movies" to "/category/movies/"),
)
