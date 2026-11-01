package com.mystreamer.aflam

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class AflamPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Aflam())
    }
}
