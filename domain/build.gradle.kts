plugins {
    id("java-library")
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api(Deps.dagger)
    api(Deps.Kotlin.stdlib)
    api(Deps.Kotlin.Coroutines.core)

    testImplementation(Deps.Test.assertj)
    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Test.mockK)
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