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

    buildFeatures.compose = true
    kotlinOptions.allWarningsAsErrors = true
    composeOptions.kotlinCompilerExtensionVersion = Versions.AndroidX.Compose.version

    compileSdk = Versions.Android.Sdk.compile
    defaultConfig {
        applicationId = "com.soberg.openbp"
        versionCode = 1
        versionName = "1.0"

        minSdk = Versions.Android.Sdk.min
        targetSdk = Versions.Android.Sdk.target
        testInstrumentationRunner = TestRunners.androidJUnit
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
