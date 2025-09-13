plugins {
    alias(libs.plugins.custom.kotlin.library)
}

dependencies {
    api(libs.javax.inject)
    api(libs.coroutines.core)
    api(libs.container)
    testImplementation(libs.junit)
}