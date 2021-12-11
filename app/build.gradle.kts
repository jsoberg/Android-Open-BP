plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation(project(":data"))

    implementation(Deps.Kotlin.stdlib)

    kapt(Deps.Hilt.compiler)
    implementation(Deps.Hilt.android)
}

android {
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        allWarningsAsErrors = true
    }

    compileSdk = Deps.Android.Sdk.Version.compileSdk
    defaultConfig {
        applicationId = "com.soberg.openbp"
        versionCode = 1
        versionName = "1.0"

        minSdk = Deps.Android.Sdk.Version.minSdk
        targetSdk = Deps.Android.Sdk.Version.targetSdk
        testInstrumentationRunner = TestRunner.androidJUnit
    }

    sourceSets {
        sourceSets["main"].java.srcDirs("src/main/kotlin")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
