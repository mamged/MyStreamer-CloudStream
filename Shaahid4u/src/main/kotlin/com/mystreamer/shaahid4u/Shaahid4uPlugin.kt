package com.mystreamer.shaahid4u

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class Shaahid4uPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Shaahid4u())
    }
}
