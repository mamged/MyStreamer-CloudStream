package com.mystreamer.oldakwam

import com.lagradost.cloudstream3.TvType

// MyStreamer port — OldAkwam
// Original primary domain: https://old.akwam.ss
// No alternate domain recovered.
// 
class Oldakwam : MyStreamerBase(
    providerName = "OldAkwam",
    providerUrl = "https://old.akwam.ss",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
