package com.mystreamer.aflamfree

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class AflamfreePlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Aflamfree())
    }
}
