version = 1

cloudstream {
    description = "MyStreamer port: CimaLina — https://tv.cemalen.shop"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/cimalina_provider.png"
}

android {
    namespace = "com.mystreamer.cimalina"
    buildFeatures {
        buildConfig = true
    }
}
