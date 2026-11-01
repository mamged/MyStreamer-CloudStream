package com.mystreamer.brstej

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class BrstejPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Brstej())
    }
}
