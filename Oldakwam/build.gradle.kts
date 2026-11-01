version = 1

cloudstream {
    description = "MyStreamer port: OldAkwam — https://old.akwam.ss"
    authors = listOf("MNASR")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
    language = "ar"
    iconUrl = "https://raw.githubusercontent.com/mamged/MyStreamer-CloudStream/main/icons/oldakwam_provider.png"
}

android {
    namespace = "com.mystreamer.oldakwam"
    buildFeatures {
        buildConfig = true
    }
}
