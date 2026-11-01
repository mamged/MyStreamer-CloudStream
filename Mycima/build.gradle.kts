version = 1

cloudstream {
    description = "MyStreamer port: MyCima — https://cima.my-cima.net"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/mycima_provider.png"
}

android {
    namespace = "com.mystreamer.mycima"
    buildFeatures {
        buildConfig = true
    }
}
