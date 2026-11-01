package com.mystreamer.cimalina

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class CimalinaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Cimalina())
    }
}
