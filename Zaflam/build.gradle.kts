version = 1

cloudstream {
    description = "MyStreamer port: Zaflam — https://zaflam.com"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/zaflam_provider.png"
}

android {
    namespace = "com.mystreamer.zaflam"
    buildFeatures {
        buildConfig = true
    }
}
