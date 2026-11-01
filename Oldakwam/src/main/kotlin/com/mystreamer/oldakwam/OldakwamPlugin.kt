package com.mystreamer.oldakwam

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class OldakwamPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Oldakwam())
    }
}
