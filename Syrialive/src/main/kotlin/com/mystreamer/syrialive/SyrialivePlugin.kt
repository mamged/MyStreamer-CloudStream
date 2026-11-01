package com.mystreamer.syrialive

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class SyrialivePlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Syrialive())
    }
}
