plugins {
    kotlin("jvm") version "2.0.21"
}

group = "info.coroutine"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //코루틴 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
