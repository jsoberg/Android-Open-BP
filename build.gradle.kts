plugins {
    id("org.jetbrains.kotlinx.kover") version Versions.kover
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(Deps.Android.gradlePlugin)
        classpath(Deps.Kotlin.gradlePlugin)
        classpath(Deps.Hilt.agp)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.koverHtmlReport {
    isEnabled = true
    htmlReportDir.set(layout.buildDirectory.dir("kover/html"))
}