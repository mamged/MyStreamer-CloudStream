package com.mystreamer.egynow

import com.lagradost.cloudstream3.TvType

// MyStreamer port — EgyNow
// Original primary domain: https://www.egynow.buzz
// Alternate domains: https://egynow.quest, https://www.egynow.my/
// Live / sports provider in the original (m3u8 streams).
class Egynow : MyStreamerBase(
    providerName = "EgyNow",
    providerUrl = "https://www.egynow.buzz",
    providerTypes = setOf(TvType.Live),
    searchPath = "/?s=",
    mainPages = listOf(),
)
