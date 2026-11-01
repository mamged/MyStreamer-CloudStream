package com.mystreamer.getkoora

import com.lagradost.cloudstream3.TvType

// MyStreamer port — GetKoora
// Original primary domain: https://getkoora.quest
// No alternate domain recovered.
// Live sports provider.
class Getkoora : MyStreamerBase(
    providerName = "GetKoora",
    providerUrl = "https://getkoora.quest",
    providerTypes = setOf(TvType.Live),
    searchPath = "/?s=",
    mainPages = listOf(),
)
