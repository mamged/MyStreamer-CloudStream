package com.mystreamer.aflamfree

import com.lagradost.cloudstream3.TvType

// MyStreamer port — AflamFree
// Original primary domain: https://aflamfree.one
// No alternate domain recovered.
// 
class Aflamfree : MyStreamerBase(
    providerName = "AflamFree",
    providerUrl = "https://aflamfree.one",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
