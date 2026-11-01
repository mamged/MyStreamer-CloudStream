package com.mystreamer.cimalina

import com.lagradost.cloudstream3.TvType

// MyStreamer port — CimaLina
// Original primary domain: https://tv.cemalen.shop
// No alternate domain recovered.
// Original also matches cema-lin.shop / cimalina domains.
class Cimalina : MyStreamerBase(
    providerName = "CimaLina",
    providerUrl = "https://tv.cemalen.shop",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
