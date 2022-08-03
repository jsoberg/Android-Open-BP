plugins {
    id("java-library")
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api(libs.dagger)
    api(libs.kotlin.stdlib)
    api(libs.kotlin.coroutines)

    testImplementation(libs.test.assertj)
    testImplementation(libs.test.junit)
    testImplementation(libs.test.mockk)
}

sourceSets {
    main {
        java.srcDir("src/main/kotlin")
    }

    test {
        java.srcDir("src/test/kotlin")
    }
}