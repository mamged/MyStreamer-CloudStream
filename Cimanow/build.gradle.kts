version = 1

cloudstream {
    description = "MyStreamer port: CimaNow — https://cimanow.cc"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/cimanow_provider.png"
}

android {
    namespace = "com.mystreamer.cimanow"
    buildFeatures {
        buildConfig = true
    }
}
