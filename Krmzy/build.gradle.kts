version = 1

cloudstream {
    description = "MyStreamer port: Krmzy — https://krmzy.org"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/krmzy_provider.png"
}

android {
    namespace = "com.mystreamer.krmzy"
    buildFeatures {
        buildConfig = true
    }
}
