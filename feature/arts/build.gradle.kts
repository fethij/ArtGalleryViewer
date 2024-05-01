plugins {
    alias(libs.plugins.artGalleryViewer.android.library)
    alias(libs.plugins.artGalleryViewer.android.library.compose)
    alias(libs.plugins.artGalleryViewer.android.feature)
}

android {
    namespace = "com.example.artGalleryViewer.feature.arts"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.model)

    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.ui.tooling.preview.android)
    debugImplementation(libs.androidx.ui.tooling)

    testImplementation(projects.core.testing)
}