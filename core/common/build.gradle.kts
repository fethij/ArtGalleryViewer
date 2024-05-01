plugins {
    alias(libs.plugins.artGalleryViewer.android.library)
    alias(libs.plugins.artGalleryViewer.android.hilt)
}

android {
    namespace = "com.example.artGalleryViewer.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(projects.core.testing)
}