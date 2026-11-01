package com.mystreamer.moviegate

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class MoviegatePlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Moviegate())
    }
}
