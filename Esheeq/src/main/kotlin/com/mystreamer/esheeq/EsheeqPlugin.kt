package com.mystreamer.esheeq

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class EsheeqPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Esheeq())
    }
}
