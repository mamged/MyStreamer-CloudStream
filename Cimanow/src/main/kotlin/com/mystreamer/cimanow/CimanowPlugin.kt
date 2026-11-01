package com.mystreamer.cimanow

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class CimanowPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Cimanow())
    }
}
