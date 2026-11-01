package com.mystreamer.esheeq

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Esheeq
// Original primary domain: https://esk.quest
// No alternate domain recovered.
// Turkish series specialist.
class Esheeq : MyStreamerBase(
    providerName = "Esheeq",
    providerUrl = "https://esk.quest",
    providerTypes = setOf(TvType.TvSeries, TvType.Movie),
    searchPath = "/?s=",
    mainPages = listOf("Turkish Series" to "/turk-series/"),
)
