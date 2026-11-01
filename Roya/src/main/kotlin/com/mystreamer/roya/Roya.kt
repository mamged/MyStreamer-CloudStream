package com.mystreamer.roya

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Roya
// Original primary domain: https://roya.tv
// No alternate domain recovered.
// Live TV. Original also used fast.kwikmotion.com / fasttvcdn.com playlists for Roya channels.
class Roya : MyStreamerBase(
    providerName = "Roya",
    providerUrl = "https://roya.tv",
    providerTypes = setOf(TvType.Live),
    searchPath = "/?s=",
    mainPages = listOf(),
)
