version = 1

cloudstream {
    description = "MyStreamer port: Aflam — https://aflam.top"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/aflam_provider.png"
}

android {
    namespace = "com.mystreamer.aflam"
    buildFeatures {
        buildConfig = true
    }
}
