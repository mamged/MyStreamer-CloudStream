version = 1

cloudstream {
    description = "MyStreamer port: ShoofLive — https://shooflive.watch"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/shooflive_provider.png"
}

android {
    namespace = "com.mystreamer.shooflive"
    buildFeatures {
        buildConfig = true
    }
}
