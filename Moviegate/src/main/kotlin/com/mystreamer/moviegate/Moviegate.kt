package com.mystreamer.moviegate

import com.lagradost.cloudstream3.TvType

// MyStreamer port — MovieGate
// Original primary domain: https://moviegate.one
// No alternate domain recovered.
// Movie-focused.
class Moviegate : MyStreamerBase(
    providerName = "MovieGate",
    providerUrl = "https://moviegate.one",
    providerTypes = setOf(TvType.Movie),
    searchPath = "/?s=",
    mainPages = listOf("All Movies" to "/category/movis/all-movies/", "Turkish Movies" to "/category/movis/turkish-movies/", "Indian Movies" to "/category/movis/indian-movies/"),
)
