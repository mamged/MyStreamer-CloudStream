package com.mystreamer.mycima

import com.lagradost.cloudstream3.TvType

// MyStreamer port — MyCima
// Original primary domain: https://cima.my-cima.net
// No alternate domain recovered.
// 
class Mycima : MyStreamerBase(
    providerName = "MyCima",
    providerUrl = "https://cima.my-cima.net",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
