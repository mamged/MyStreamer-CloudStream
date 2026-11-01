package com.mystreamer.tvsiir

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class TvsiirPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Tvsiir())
    }
}
