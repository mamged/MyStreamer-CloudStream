version = 1

cloudstream {
    description = "MyStreamer port: Rotana — https://rotana.net"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Live")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/rotana_provider.png"
}

android {
    namespace = "com.mystreamer.rotana"
    buildFeatures {
        buildConfig = true
    }
}
