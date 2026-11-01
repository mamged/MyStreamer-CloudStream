package com.mystreamer.fushaar

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class FushaarPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Fushaar())
    }
}
