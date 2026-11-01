package com.mystreamer.cimawbs

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class CimawbsPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Cimawbs())
    }
}
