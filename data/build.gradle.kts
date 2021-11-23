plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    api(Deps.Kotlin.stdlib)

    kapt(Deps.AndroidX.Room.compiler)
    api(Deps.AndroidX.Room.runtime)
    api(Deps.AndroidX.Room.kotlinExtensions)

    kapt(Deps.Hilt.compiler)
    implementation(Deps.Hilt.android)

    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Test.assertj)
}

android {
    compileSdk = Deps.Android.Sdk.Version.compileSdk

    defaultConfig {
        minSdk = Deps.Android.Sdk.Version.minSdk
        targetSdk = Deps.Android.Sdk.Version.targetSdk
    }

    sourceSets["main"].java.srcDirs("src/main/kotlin")
    sourceSets["test"].java.srcDirs(
        "src/unitTest/kotlin",
    )
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}