version = 1

cloudstream {
    description = "MyStreamer port: Shaahid4U — https://shahid4us.com"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/shaahid4u_provider.png"
}

android {
    namespace = "com.mystreamer.shaahid4u"
    buildFeatures {
        buildConfig = true
    }
}
