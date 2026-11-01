package com.mystreamer.egybests

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class EgybestsPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Egybests())
    }
}
