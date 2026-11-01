version = 1

cloudstream {
    description = "MyStreamer port: KooraWeb — https://kooralovers.com"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Live")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/kooraweb_provider.png"
}

android {
    namespace = "com.mystreamer.kooraweb"
    buildFeatures {
        buildConfig = true
    }
}
