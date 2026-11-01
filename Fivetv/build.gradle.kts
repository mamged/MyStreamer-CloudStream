version = 1

cloudstream {
    description = "MyStreamer port: FiveTV — https://new61.5tv.lol"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries", "Anime")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/fivetv_provider.png"
}

android {
    namespace = "com.mystreamer.fivetv"
    buildFeatures {
        buildConfig = true
    }
}
