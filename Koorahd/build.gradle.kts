version = 1

cloudstream {
    description = "MyStreamer port: KooraHD — https://alkora.club"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Live")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/koorahd_provider.png"
}

android {
    namespace = "com.mystreamer.koorahd"
    buildFeatures {
        buildConfig = true
    }
}
