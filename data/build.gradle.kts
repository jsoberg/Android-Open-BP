plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    api(project(":domain"))

    kapt(Deps.AndroidX.Room.compiler)
    api(Deps.AndroidX.Room.runtime)
    api(Deps.AndroidX.Room.kotlinExtensions)

    kapt(Deps.Hilt.compiler)
    implementation(Deps.Hilt.android)

    testImplementation(Deps.Test.assertj)
    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Test.robolectric)
}

android {
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions.allWarningsAsErrors = true
    testOptions.unitTests.isIncludeAndroidResources = true

    compileSdk = Versions.Android.Sdk.compile
    defaultConfig {
        minSdk = Versions.Android.Sdk.min
        targetSdk = Versions.Android.Sdk.target
        testInstrumentationRunner = TestRunners.androidJUnit
    }

    sourceSets["main"].java.srcDirs("src/main/kotlin")
    sourceSets["test"].java.srcDirs("src/unitTest/kotlin")
}