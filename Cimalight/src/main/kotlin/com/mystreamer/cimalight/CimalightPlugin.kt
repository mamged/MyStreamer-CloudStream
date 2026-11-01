package com.mystreamer.cimalight

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class CimalightPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Cimalight())
    }
}
