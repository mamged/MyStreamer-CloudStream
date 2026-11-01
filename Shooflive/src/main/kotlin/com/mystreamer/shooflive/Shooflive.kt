package com.mystreamer.shooflive

import com.lagradost.cloudstream3.TvType

// MyStreamer port — ShoofLive
// Original primary domain: https://shooflive.watch
// Alternate domains: https://q2.shooflive.sbs
// 
class Shooflive : MyStreamerBase(
    providerName = "ShoofLive",
    providerUrl = "https://shooflive.watch",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf("Movies" to "/movies/", "Series" to "/series/"),
)
