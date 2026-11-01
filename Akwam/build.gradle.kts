version = 1

cloudstream {
    description = "MyStreamer port: Akwam — https://akwam.ss"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/akwam_provider.png"
}

android {
    namespace = "com.mystreamer.akwam"
    buildFeatures {
        buildConfig = true
    }
}
