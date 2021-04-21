package com.soberg.openbp.buildsrc

object Deps {

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha14"

    const val junit = "junit:junit:4.13"
    const val material = "com.google.android.material:material:1.1.0"

    object Kotlin {
        private const val version = "1.4.32"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.3.0-beta01"
        const val coreKtx = "androidx.core:core-ktx:1.5.0-beta03"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha05"
        }

        object Compose {
            private const val version = "1.0.0-beta03"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val test = "androidx.compose.ui:ui-test:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:${version}"
            const val viewBinding = "androidx.compose.ui:ui-viewbinding:$version"
        }

        object Lifecycle {
            private const val version = "2.3.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha03"
        }

        object Navigation {
            private const val version = "2.3.3"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Room {
            private const val version = " 2.2.6"
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
}
