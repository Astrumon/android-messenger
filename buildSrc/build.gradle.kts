
plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.plugin.android.application)
    implementation(libs.plugin.android.library)
    implementation(libs.plugin.kotlin.jvm)
    implementation(libs.plugin.kotlin.android)
    implementation(libs.plugin.kotlin.compose)

}