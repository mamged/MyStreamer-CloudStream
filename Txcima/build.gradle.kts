version = 1

cloudstream {
    description = "MyStreamer port: TxCima — https://txc.txcima.com"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/txcima_provider.png"
}

android {
    namespace = "com.mystreamer.txcima"
    buildFeatures {
        buildConfig = true
    }
}
