package com.mystreamer.mywecima

import com.lagradost.cloudstream3.TvType

// MyStreamer port — MyWecima
// Original primary domain: https://myweecima.shop
// Alternate domains: https://mywecima.work, https://mycima.gdn, https://wecima.cx
// 
class Mywecima : MyStreamerBase(
    providerName = "MyWecima",
    providerUrl = "https://myweecima.shop",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/?s=",
    mainPages = listOf(),
)
