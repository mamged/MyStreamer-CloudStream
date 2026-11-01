version = 1

cloudstream {
    description = "MyStreamer port: TukCima — https://tukcima.com"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/tukcima_provider.png"
}

android {
    namespace = "com.mystreamer.tukcima"
    buildFeatures {
        buildConfig = true
    }
}
