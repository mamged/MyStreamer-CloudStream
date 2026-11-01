package com.mystreamer.shaahid4u

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Shaahid4U
// Original primary domain: https://shaahidd4u.net
// No alternate domain recovered.
// 
class Shaahid4u : MyStreamerBase(
    providerName = "Shaahid4U",
    providerUrl = "https://shahid4us.com",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/search?s=",
    mainPages = listOf(),
)
