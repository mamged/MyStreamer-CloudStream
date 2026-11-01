package com.mystreamer.movizland

import com.lagradost.cloudstream3.TvType

// MyStreamer port — MovizLand
// Original primary domain: https://www.moviz.land
// No alternate domain recovered.
// 
class Movizland : MyStreamerBase(
    providerName = "MovizLand",
    providerUrl = "https://www.moviz.land",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf("Movies" to "/movies/"),
)
