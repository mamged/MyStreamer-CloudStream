version = 1

cloudstream {
    description = "MyStreamer port: MyWecima — https://myweecima.shop"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/mywecima_provider.png"
}

android {
    namespace = "com.mystreamer.mywecima"
    buildFeatures {
        buildConfig = true
    }
}
