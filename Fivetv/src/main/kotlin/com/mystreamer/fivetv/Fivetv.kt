package com.mystreamer.fivetv

import com.lagradost.cloudstream3.TvType

// MyStreamer port — FiveTV
// Original primary domain: https://new61.5tv.lol
// No alternate domain recovered.
// 
class Fivetv : MyStreamerBase(
    providerName = "FiveTV",
    providerUrl = "https://new61.5tv.lol",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries, TvType.Anime),
    searchPath = "/search/?q=",
    mainPages = listOf("Anime" to "/category/أنمي/"),
)
