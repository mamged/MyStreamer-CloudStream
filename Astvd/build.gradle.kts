version = 1

cloudstream {
    description = "MyStreamer port: AsTvD — https://astvd.com"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/astvd_provider.png"
}

android {
    namespace = "com.mystreamer.astvd"
    buildFeatures {
        buildConfig = true
    }
}
