version = 1

cloudstream {
    description = "MyStreamer port: QFilm — https://qfilm.tv"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/qfilm_provider.png"
}

android {
    namespace = "com.mystreamer.qfilm"
    buildFeatures {
        buildConfig = true
    }
}
