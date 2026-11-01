package com.mystreamer.egydead

import com.lagradost.cloudstream3.TvType

// MyStreamer port — EgyDead
// Original primary domain: https://egydead.wiki
// Alternate domains: https://egydead.live, https://egydead.link
// 
class Egydead : MyStreamerBase(
    providerName = "EgyDead",
    providerUrl = "https://egydead.wiki",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
