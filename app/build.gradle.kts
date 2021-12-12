plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation(project(":data"))

    implementation(Deps.Kotlin.stdlib)

    implementation(Deps.AndroidX.Compose.activity)
    implementation(Deps.AndroidX.Compose.foundation)
    implementation(Deps.AndroidX.Compose.material)
    implementation(Deps.AndroidX.Compose.runtime)
    implementation(Deps.AndroidX.Compose.tooling)
    implementation(Deps.AndroidX.Lifecycle.composeViewModelUtilities)
    implementation(Deps.AndroidX.Lifecycle.viewModel)

    kapt(Deps.Hilt.compiler)
    implementation(Deps.Hilt.android)
}

android {
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Deps.AndroidX.Compose.kotlinCompilerExtensionVersion
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
