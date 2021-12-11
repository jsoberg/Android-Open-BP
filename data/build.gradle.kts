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

    androidTestImplementation(Deps.Android.Test.assertj)
    androidTestImplementation(Deps.AndroidX.Test.core)
    androidTestImplementation(Deps.AndroidX.Test.Ext.junit)
    androidTestImplementation(Deps.Kotlin.Coroutines.test)
}

android {
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    compileSdk = Deps.Android.Sdk.Version.compileSdk
    defaultConfig {
        minSdk = Deps.Android.Sdk.Version.minSdk
        targetSdk = Deps.Android.Sdk.Version.targetSdk
        testInstrumentationRunner = TestRunner.androidJUnit
    }

    packagingOptions {
        resources {
            // Workaround for issues with Kotlin coroutines-test dependency.
            // See https://github.com/Kotlin/kotlinx.coroutines/issues/2023.
            excludes += "META-INF/AL2.0"
            excludes += "META-INF/LGPL2.1"
        }
    }

    sourceSets["main"].java.srcDirs("src/main/kotlin")
    sourceSets["test"].java.srcDirs("src/androidTest/kotlin")
}