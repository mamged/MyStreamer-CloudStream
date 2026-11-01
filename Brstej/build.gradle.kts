version = 1

cloudstream {
    description = "MyStreamer port: Brstej — https://brstejj.quest"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/brstej_provider.png"
}

android {
    namespace = "com.mystreamer.brstej"
    buildFeatures {
        buildConfig = true
    }
}
