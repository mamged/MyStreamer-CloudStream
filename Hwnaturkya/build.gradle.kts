version = 1

cloudstream {
    description = "MyStreamer port: HwanaTurkya — https://www.hwnaturkya.com"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("TvSeries", "Movie")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/hwnaturkya_provider.png"
}

android {
    namespace = "com.mystreamer.hwnaturkya"
    buildFeatures {
        buildConfig = true
    }
}
