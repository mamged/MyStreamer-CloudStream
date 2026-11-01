package com.mystreamer.lodynet

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class LodynetPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Lodynet())
    }
}
