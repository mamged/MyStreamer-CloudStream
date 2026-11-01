package com.mystreamer.animezid

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class AnimezidPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Animezid())
    }
}
