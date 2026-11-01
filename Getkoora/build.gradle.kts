version = 1

cloudstream {
    description = "MyStreamer port: GetKoora — https://getkoora.quest"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Live")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/getkoora_provider.png"
}

android {
    namespace = "com.mystreamer.getkoora"
    buildFeatures {
        buildConfig = true
    }
}
