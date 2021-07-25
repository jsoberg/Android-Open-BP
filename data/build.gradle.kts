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

    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Test.junit)
}

android {
    compileSdk = Deps.Android.Sdk.Version.compileSdk

    defaultConfig {
        minSdk = Deps.Android.Sdk.Version.minSdk
        targetSdk = Deps.Android.Sdk.Version.targetSdk
    }

    sourceSets["main"].java.srcDirs("src/main/kotlin")
    sourceSets["test"].java.srcDirs("src/test/kotlin")

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