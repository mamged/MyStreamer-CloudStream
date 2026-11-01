version = 1

cloudstream {
    description = "MyStreamer port: LodyNet — https://lodynet.top"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/lodynet_provider.png"
}

android {
    namespace = "com.mystreamer.lodynet"
    buildFeatures {
        buildConfig = true
    }
}
