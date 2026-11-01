version = 1

cloudstream {
    description = "MyStreamer port: SyriaLive — https://syrialive.boats"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Live")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/syrialive_provider.png"
}

android {
    namespace = "com.mystreamer.syrialive"
    buildFeatures {
        buildConfig = true
    }
}
