object Deps {

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.0.0"
        const val material = "com.google.android.material:material:1.3.0"

        object Sdk {
            object Version {
                const val minSdk = 21
                const val compileSdk = 30
                const val targetSdk = 30
            }
        }
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.3.0-beta01"
        const val coreKtx = "androidx.core:core-ktx:1.5.0-beta03"

        object ConstraintLayout {
            private const val version = "2.0.4"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
        }

        object Lifecycle {
            private const val version = "2.3.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Navigation {
            private const val version = "2.3.3"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Room {
            private const val version = "2.2.6"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val kotlinExtensions = "androidx.room:room-ktx:$version"

            const val test = "androidx.room:room-testing:$version"
        }

        object Test {
            private const val version = "1.3.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    object Hilt {
        private const val version = "2.38.1"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Kotlin {
        private const val version = "1.5.21"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        private const val coroutinesVersion = "1.3.9"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    }

    object Test {
        const val junit = "junit:junit:4.13"
        const val assertj = "org.assertj:assertj-core:3.20.2"
    }
}
