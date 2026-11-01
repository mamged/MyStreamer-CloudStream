package com.mystreamer.shahiidanime

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class ShahiidanimePlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Shahiidanime())
    }
}
