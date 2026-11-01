package com.mystreamer.fivetv

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class FivetvPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Fivetv())
    }
}
