package com.mystreamer.egybests

import com.lagradost.cloudstream3.TvType

// MyStreamer port — EgyBests
// Original primary domain: https://egibest.life
// No alternate domain recovered.
// Icon file in the original is egybest_provider.png.
class Egybests : MyStreamerBase(
    providerName = "EgyBests",
    providerUrl = "https://egibest.life",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
