package com.mystreamer.cimanow

import com.lagradost.cloudstream3.TvType

// MyStreamer port — CimaNow
// Original primary domain: https://cimanow.cc
// No alternate domain recovered.
// Largest module in the original IPK (1.3 MB compiled).
class Cimanow : MyStreamerBase(
    providerName = "CimaNow",
    providerUrl = "https://cimanow.cc",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf("Movies" to "/category/افلام-اجنبية/", "Series" to "/category/مسلسلات-اجنبية/", "Arabic Series" to "/category/مسلسلات-عربية/", "Turkish Series" to "/category/مسلسلات-تركية/"),
)
