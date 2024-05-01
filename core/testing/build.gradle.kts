plugins {
    alias(libs.plugins.artGalleryViewer.android.library)
    alias(libs.plugins.artGalleryViewer.android.library.compose)
    alias(libs.plugins.artGalleryViewer.android.hilt)
}

android {
    namespace = "com.example.artGalleryViewer.core.testing"
}

dependencies {
    api(libs.androidx.test.rules)
    api(libs.androidx.test.runner)
    api(libs.hilt.android.testing)
    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)
    api(libs.androidx.compose.ui.test)
    api(libs.androidx.compose.ui.testManifest)
    api(libs.turbine)

    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.model)
}
