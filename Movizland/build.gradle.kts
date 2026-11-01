version = 1

cloudstream {
    description = "MyStreamer port: MovizLand — https://www.moviz.land"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/movizland_provider.png"
}

android {
    namespace = "com.mystreamer.movizland"
    buildFeatures {
        buildConfig = true
    }
}
