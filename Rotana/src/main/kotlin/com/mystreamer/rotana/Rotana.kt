package com.mystreamer.rotana

import com.lagradost.cloudstream3.TvType

// MyStreamer port — Rotana
// Original primary domain: https://rotana.net
// No alternate domain recovered.
// Live TV channels. Original fetches now-playing from rotana.net and Hibrid streaming embeds; channel list in CloudStream is generic until the embed resolver is tuned per channel.
class Rotana : MyStreamerBase(
    providerName = "Rotana",
    providerUrl = "https://rotana.net",
    providerTypes = setOf(TvType.Live),
    searchPath = "/?s=",
    mainPages = listOf(),
)
