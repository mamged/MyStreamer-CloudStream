package com.mystreamer.hwnaturkya

import com.lagradost.cloudstream3.TvType

// MyStreamer port — HwanaTurkya
// Original primary domain: https://www.hwnaturkya.com
// No alternate domain recovered.
// Turkish content.
class Hwnaturkya : MyStreamerBase(
    providerName = "HwanaTurkya",
    providerUrl = "https://www.hwnaturkya.com",
    providerTypes = setOf(TvType.TvSeries, TvType.Movie),
    searchPath = "/?s=",
    mainPages = listOf(),
)
