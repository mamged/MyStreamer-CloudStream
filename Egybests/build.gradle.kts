version = 1

cloudstream {
    description = "MyStreamer port: EgyBests — https://egibest.life"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/egybests_provider.png"
}

android {
    namespace = "com.mystreamer.egybests"
    buildFeatures {
        buildConfig = true
    }
}
