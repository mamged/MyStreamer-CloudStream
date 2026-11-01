package com.mystreamer.krmzy

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class KrmzyPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Krmzy())
    }
}
