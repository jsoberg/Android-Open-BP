plugins {
    id("java-library")
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api(Deps.Dagger.core)
    api(Deps.Kotlin.stdlib)
    api(Deps.Kotlin.Coroutines.core)

    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Test.assertj)
}

sourceSets {
    main {
        java {
            srcDir("src/main/kotlin")
        }
    }

    test {
        java {
            srcDir("src/unitTest/kotlin")
        }
    }
}