version = 1

cloudstream {
    description = "MyStreamer port: AhwakTV — https://ahwaktv.net"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/ahwaktv_provider.png"
}

android {
    namespace = "com.mystreamer.ahwaktv"
    buildFeatures {
        buildConfig = true
    }
}
