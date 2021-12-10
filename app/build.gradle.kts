plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation(project(":data"))

    implementation(Deps.Kotlin.stdlib)

    implementation(Deps.Android.material)
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.AndroidX.Lifecycle.livedata)
    implementation(Deps.AndroidX.Lifecycle.viewmodel)
    implementation(Deps.AndroidX.Navigation.fragment)
    implementation(Deps.AndroidX.Navigation.uiKtx)
    implementation(Deps.AndroidX.ConstraintLayout.constraintLayout)

    implementation(Deps.Hilt.android)
    kapt(Deps.Hilt.compiler)

    androidTestImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.AndroidX.Test.core)
    androidTestImplementation(Deps.AndroidX.Test.espressoCore)
    androidTestImplementation(Deps.AndroidX.Test.rules)
    androidTestImplementation(Deps.AndroidX.Test.Ext.junit)
}

android {

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "com.soberg.openbp"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = "1.8"
    }
}
