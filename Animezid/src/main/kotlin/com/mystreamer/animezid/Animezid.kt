package com.mystreamer.animezid

import com.lagradost.cloudstream3.TvType

// MyStreamer port — AnimeZid
// Original primary domain: https://animezid.org
// No alternate domain recovered.
// Anime provider.
class Animezid : MyStreamerBase(
    providerName = "AnimeZid",
    providerUrl = "https://animezid.org",
    providerTypes = setOf(TvType.Anime),
    searchPath = "/?s=",
    mainPages = listOf(),
)
