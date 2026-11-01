version = 1

cloudstream {
    description = "MyStreamer port: Fushaar — https://fussshaar.yachts"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/fushaar_provider.png"
}

android {
    namespace = "com.mystreamer.fushaar"
    buildFeatures {
        buildConfig = true
    }
}
