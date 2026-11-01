package com.mystreamer.koorahd

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class KoorahdPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Koorahd())
    }
}
