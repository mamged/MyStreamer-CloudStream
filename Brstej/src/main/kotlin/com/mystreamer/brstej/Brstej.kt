package com.mystreamer.brstej

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Brstej
// Original primary domain: https://brstejj.quest
// No alternate domain recovered.
// Note the site domain spelling brsteej.lol, provider folder brstej.
class Brstej : MyStreamerBase(
    providerName = "Brstej",
    providerUrl = "https://brstejj.quest",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/search.php?keywords=",
    mainPages = listOf(),
)
