package com.mystreamer.roya

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class RoyaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Roya())
    }
}
