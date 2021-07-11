plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation(Deps.Kotlin.stdlib)

    kapt(Deps.AndroidX.Room.compiler)
    implementation(Deps.AndroidX.Room.runtime)
    implementation(Deps.AndroidX.Room.kotlinExtensions)
}

android {
    compileSdk = Deps.Sdk.Version.compileSdk

    defaultConfig {
        minSdk = Deps.Sdk.Version.minSdk
        targetSdk = Deps.Sdk.Version.targetSdk
    }

    sourceSets["main"].java.srcDirs("src/main/kotlin")

    kotlin {
        sourceSets.all {
            languageSettings.enableLanguageFeature("InlineClasses")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}