version = 1

cloudstream {
    description = "MyStreamer port: Roya — https://roya.tv"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Live")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/roya_provider.png"
}

android {
    namespace = "com.mystreamer.roya"
    buildFeatures {
        buildConfig = true
    }
}
