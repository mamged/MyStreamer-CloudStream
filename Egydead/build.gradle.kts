version = 1

cloudstream {
    description = "MyStreamer port: EgyDead — https://egydead.wiki"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/egydead_provider.png"
}

android {
    namespace = "com.mystreamer.egydead"
    buildFeatures {
        buildConfig = true
    }
}
