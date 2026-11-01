version = 1

cloudstream {
    description = "MyStreamer port: CimaLight — https://e.cimalight.co"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/cimalight_provider.png"
}

android {
    namespace = "com.mystreamer.cimalight"
    buildFeatures {
        buildConfig = true
    }
}
