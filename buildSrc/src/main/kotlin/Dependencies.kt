object Deps {

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.0.0"

        object Sdk {
            object Version {
                const val minSdk = 21
                const val compileSdk = 31
                const val targetSdk = 31
            }
        }

        object Test {
            const val assertj = "com.squareup.assertj:assertj-android:1.0.0"
        }
    }

    object AndroidX {
        object Compose {
            private const val version = "1.0.5"
            const val animation = "androidx.compose.animation:animation:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"

            const val kotlinCompilerExtensionVersion = "1.0.5"
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
            const val runner = "androidx.test:runner:$version"

            object Ext {
                private const val version = "1.1.3"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }
        }
    }

    object Hilt {
        private const val version = "2.38.1"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Kotlin {
        private const val version = "1.5.31"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.5.2"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Test {
        const val junit = "junit:junit:4.13"

        private const val assertjVersion = "3.21.0"
        const val assertj = "org.assertj:assertj-core:$assertjVersion"
    }
}

object TestRunner {
    const val androidJUnit = "androidx.test.runner.AndroidJUnitRunner"
}
