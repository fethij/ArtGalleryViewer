plugins {
    alias(libs.plugins.artGalleryViewer.android.library)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.artGalleryViewer.core.domain"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.model)

    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.android)

    ksp(libs.hilt.compiler)

    testImplementation(projects.core.testing)
}