plugins {
    alias(libs.plugins.custom.kotlin.script)
}

kotlinScript {
    scriptName = "create"
    mainClass = "com.ua.astrumon.templates.script.MainKt"
}


tasks.register<Copy>("bundleScript") {
    doNotTrackState("Bundling script")
    dependsOn("fatJar")
    group = "build"
    from(tasks.named("fatJar").get().outputs.files)
    into(rootDir)
}


dependencies {

}