package com.mystreamer.okanime

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class OkanimePlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Okanime())
    }
}
