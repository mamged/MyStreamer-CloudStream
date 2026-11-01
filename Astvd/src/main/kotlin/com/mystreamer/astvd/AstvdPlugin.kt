package com.mystreamer.astvd

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class AstvdPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Astvd())
    }
}
