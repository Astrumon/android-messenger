plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.ua.astrumon.messenger.feature.init.presentation"
}

dependencies {
    api(projects.features.init.domain)
    implementation(projects.core.essentials)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
}
