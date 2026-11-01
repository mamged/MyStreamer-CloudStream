package com.mystreamer.tukcima

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class TukcimaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Tukcima())
    }
}
