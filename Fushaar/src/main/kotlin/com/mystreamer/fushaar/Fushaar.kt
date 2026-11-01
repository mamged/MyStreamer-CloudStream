package com.mystreamer.fushaar

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Fushaar
// Original primary domain: https://fussshaar.yachts
// No alternate domain recovered.
// Note triple-s domain fussshaar.rest.
class Fushaar : MyStreamerBase(
    providerName = "Fushaar",
    providerUrl = "https://fussshaar.yachts",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
