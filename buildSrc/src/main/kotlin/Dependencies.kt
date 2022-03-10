object Deps {
    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:${Versions.Android.agp}"

        object Test {
            const val assertj = "com.squareup.assertj:assertj-android:${Versions.Android.assertJ}"
        }
    }

    object AndroidX {
        object Compose {
            const val activity =
                "androidx.activity:activity-compose:${Versions.AndroidX.Compose.activity}"

            const val animation =
                "androidx.compose.animation:animation:${Versions.AndroidX.Compose.version}"
            const val foundation =
                "androidx.compose.foundation:foundation:${Versions.AndroidX.Compose.version}"
            const val material =
                "androidx.compose.material:material:${Versions.AndroidX.Compose.version}"
            const val runtime =
                "androidx.compose.runtime:runtime:${Versions.AndroidX.Compose.version}"
            const val tooling =
                "androidx.compose.ui:ui-tooling:${Versions.AndroidX.Compose.version}"
        }

        object Lifecycle {
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycle}"
            const val composeViewModelUtilities =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.AndroidX.lifecycle}"
        }

        object Room {
            const val runtime = "androidx.room:room-runtime:${Versions.AndroidX.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.AndroidX.room}"
            const val kotlinExtensions = "androidx.room:room-ktx:${Versions.AndroidX.room}"

            const val test = "androidx.room:room-testing:${Versions.AndroidX.room}"
        }

        object Test {
            const val core = "androidx.test:core:${Versions.AndroidX.test}"
            const val rules = "androidx.test:rules:${Versions.AndroidX.test}"
            const val runner = "androidx.test:runner:${Versions.AndroidX.test}"

            object Ext {
                const val junit = "androidx.test.ext:junit-ktx:${Versions.AndroidX.testJunitExt}"
            }
        }
    }

    const val dagger = "com.google.dagger:dagger:${Versions.AndroidX.dagger}"

    object Hilt {
        const val agp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.AndroidX.dagger}"
        const val android = "com.google.dagger:hilt-android:${Versions.AndroidX.dagger}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.AndroidX.dagger}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

        object Coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        }
    }

    object Test {
        const val assertj = "org.assertj:assertj-core:${Versions.assertJ}"
        const val junit = "junit:junit:${Versions.junit}"
        const val mockK = "io.mockk:mockk:${Versions.mockK}"
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    }
}
