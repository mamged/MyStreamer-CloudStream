version = 1

cloudstream {
    description = "MyStreamer port: TvSiir — https://tvsiir.co"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Live")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/tvsiir_provider.png"
}

android {
    namespace = "com.mystreamer.tvsiir"
    buildFeatures {
        buildConfig = true
    }
}
