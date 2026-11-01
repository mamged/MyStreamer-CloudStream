package com.mystreamer.txcima

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class TxcimaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(Txcima())
    }
}
