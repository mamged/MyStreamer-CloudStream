version = 1

cloudstream {
    description = "MyStreamer port: MovieGate — https://moviegate.one"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/moviegate_provider.png"
}

android {
    namespace = "com.mystreamer.moviegate"
    buildFeatures {
        buildConfig = true
    }
}
