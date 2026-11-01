package com.mystreamer.txcima

import com.lagradost.cloudstream3.TvType

// MyStreamer port — TxCima
// Original primary domain: https://txc.txcima.com
// No alternate domain recovered.
// 
class Txcima : MyStreamerBase(
    providerName = "TxCima",
    providerUrl = "https://txc.txcima.com",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
