package com.mystreamer.mywecima

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class MywecimaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Mywecima())
    }
}
