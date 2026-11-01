package com.mystreamer.hwnaturkya

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class HwnaturkyaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Hwnaturkya())
    }
}
