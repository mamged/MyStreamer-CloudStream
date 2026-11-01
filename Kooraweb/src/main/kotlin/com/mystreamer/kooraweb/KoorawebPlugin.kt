package com.mystreamer.kooraweb

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class KoorawebPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Kooraweb())
    }
}
