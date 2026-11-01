package com.mystreamer.myseed

import com.lagradost.cloudstream3.TvType

// MyStreamer port — MySeed
// Original primary domain: https://m.myseed.tv
// No alternate domain recovered.
// 
class Myseed : MyStreamerBase(
    providerName = "MySeed",
    providerUrl = "https://m.myseed.tv",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf("Arabic Movies" to "/category/arabic-movies/", "Arabic Series" to "/category/arabic-series/", "Foreign Movies" to "/category/foreign-movies/", "Foreign Series" to "/category/foreign-series/", "Turkish Series" to "/category/turkish-series/", "Animation Movies" to "/category/animation-movies/"),
)
