version = 1

cloudstream {
    description = "MyStreamer port: OkAnime — https://ww3.okanime.xyz"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Anime")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/okanime_provider.png"
}

android {
    namespace = "com.mystreamer.okanime"
    buildFeatures {
        buildConfig = true
    }
}
