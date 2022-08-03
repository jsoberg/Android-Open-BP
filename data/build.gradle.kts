plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    api(projects.domain)

    kapt(libs.room.compiler)
    api(libs.room.runtime)
    api(libs.room.kotlinExtensions)

    kapt(libs.hilt.compiler)
    implementation(libs.hilt.android)

    testImplementation(libs.test.assertj)
    testImplementation(libs.test.junit)
    testImplementation(libs.test.robolectric)
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
    sourceSets["test"].java.srcDirs("src/test/kotlin")
}