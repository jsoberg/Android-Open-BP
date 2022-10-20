plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation(projects.data)

    implementation(libs.kotlin.stdlib)

    implementation(libs.compose.activity)
    implementation(libs.compose.foundation)
    implementation(libs.hilt.navigationCompose)
    implementation(libs.compose.material)
    implementation(libs.compose.navigation)
    implementation(libs.compose.runtime)
    implementation(libs.compose.tooling)
    implementation(libs.androidX.lifecycle.composeViewModelUtilities)
    implementation(libs.androidX.lifecycle.viewModel)

    kapt(libs.hilt.compiler)
    implementation(libs.hilt.android)
}

android {
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    buildFeatures.compose = true
    kotlinOptions.allWarningsAsErrors = true
    composeOptions.kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()

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
