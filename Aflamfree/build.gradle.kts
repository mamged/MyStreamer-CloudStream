version = 1

cloudstream {
    description = "MyStreamer port: AflamFree — https://aflamfree.one"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/aflamfree_provider.png"
}

android {
    namespace = "com.mystreamer.aflamfree"
    buildFeatures {
        buildConfig = true
    }
}
