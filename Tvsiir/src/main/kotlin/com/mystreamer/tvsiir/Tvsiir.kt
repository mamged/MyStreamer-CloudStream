package com.mystreamer.tvsiir

import com.lagradost.cloudstream3.TvType

// MyStreamer port — TvSiir
// Original primary domain: https://tvsiir.co
// No alternate domain recovered.
// Live sports provider; original used a local proxy for its player.
class Tvsiir : MyStreamerBase(
    providerName = "TvSiir",
    providerUrl = "https://tvsiir.co",
    providerTypes = setOf(TvType.Live),
    searchPath = "/?s=",
    mainPages = listOf(),
)
