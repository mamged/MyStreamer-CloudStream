package com.mystreamer.myseed

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class MyseedPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Myseed())
    }
}
