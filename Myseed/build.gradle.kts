version = 1

cloudstream {
    description = "MyStreamer port: MySeed — https://m.myseed.tv"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/myseed_provider.png"
}

android {
    namespace = "com.mystreamer.myseed"
    buildFeatures {
        buildConfig = true
    }
}
