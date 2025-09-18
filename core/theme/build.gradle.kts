plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.compose)
}

android {
    namespace = "com.ua.astrumon.messenger.core.theme"
}

setupCompose()

dependencies {
    implementation(projects.core.essentials)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
