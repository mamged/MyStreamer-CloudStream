version = 1

cloudstream {
    description = "MyStreamer port: Esheeq — https://esk.quest"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("TvSeries", "Movie")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/esheeq_provider.png"
}

android {
    namespace = "com.mystreamer.esheeq"
    buildFeatures {
        buildConfig = true
    }
}
