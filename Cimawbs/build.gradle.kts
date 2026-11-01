version = 1

cloudstream {
    description = "MyStreamer port: CimaWbs — https://cimawbas.rest"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/cimawbs_provider.png"
}

android {
    namespace = "com.mystreamer.cimawbs"
    buildFeatures {
        buildConfig = true
    }
}
