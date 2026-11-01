package com.mystreamer.larooza

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Larooza
// Original primary domain: https://larooza.motorcycles
// No alternate domain recovered.
// 
class Larooza : MyStreamerBase(
    providerName = "Larooza",
    providerUrl = "https://larooza.motorcycles",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/search.php?keywords=",
    mainPages = listOf(),
)
