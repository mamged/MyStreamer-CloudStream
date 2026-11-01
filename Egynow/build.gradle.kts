version = 1

cloudstream {
    description = "MyStreamer port: EgyNow — https://www.egynow.buzz"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Live")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/egynow_provider.png"
}

android {
    namespace = "com.mystreamer.egynow"
    buildFeatures {
        buildConfig = true
    }
}
