package com.mystreamer.shahiidanime

import com.lagradost.cloudstream3.TvType

// MyStreamer port — ShahiidAnime
// Original primary domain: https://shahiid-anime.net
// No alternate domain recovered.
// Anime provider.
class Shahiidanime : MyStreamerBase(
    providerName = "ShahiidAnime",
    providerUrl = "https://shahiid-anime.net",
    providerTypes = setOf(TvType.Anime),
    searchPath = "/?s=",
    mainPages = listOf(),
)
