package com.mystreamer.ahwaktv

import com.lagradost.cloudstream3.TvType

// MyStreamer port — AhwakTV
// Original primary domain: https://ahwaktv.net
// Alternate domains: https://yam.ahwaktv.net
// Search endpoint recovered from the original module.
class Ahwaktv : MyStreamerBase(
    providerName = "AhwakTV",
    providerUrl = "https://ahwaktv.net",
    providerTypes = setOf(TvType.Movie, TvType.TvSeries),
    searchPath = "/search.php?keywords=",
    mainPages = listOf(),
)
