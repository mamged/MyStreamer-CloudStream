package com.mystreamer.rotana

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class RotanaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Rotana())
    }
}
