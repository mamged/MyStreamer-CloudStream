package com.mystreamer.egydead

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class EgydeadPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Egydead())
    }
}
