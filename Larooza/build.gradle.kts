version = 1

cloudstream {
    description = "MyStreamer port: Larooza — https://larooza.motorcycles"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/larooza_provider.png"
}

android {
    namespace = "com.mystreamer.larooza"
    buildFeatures {
        buildConfig = true
    }
}
