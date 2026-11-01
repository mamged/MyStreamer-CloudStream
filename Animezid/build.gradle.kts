version = 1

cloudstream {
    description = "MyStreamer port: AnimeZid — https://animezid.org"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Anime")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/animezid_provider.png"
}

android {
    namespace = "com.mystreamer.animezid"
    buildFeatures {
        buildConfig = true
    }
}
