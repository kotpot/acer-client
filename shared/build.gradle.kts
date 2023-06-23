plugins {
    kotlin("multiplatform")
    id("com.android.application")
    kotlin("plugin.serialization") version "1.8.21"
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

kotlin {
    android()
    jvm("desktop")
    ios()

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(project(":protocol"))
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
            }


        }
        val androidMain by getting {
            dependencies {
                dependsOn(commonMain)
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.okhttp)
            }
        }
        val iosMain by getting {
            dependencies {
                dependsOn(commonMain)
                implementation(libs.ktor.client.ios)
            }
        }
        // JVM
        val desktopMain by getting {
            dependencies {
                dependsOn(commonMain)
            }
        }
    }
}

android {
    namespace = providers.gradleProperty("android.shared.id").get()
    compileSdk = providers.gradleProperty("android.compileSdk").get().toInt()
    defaultConfig {
        applicationId = providers.gradleProperty("android.app.id").get()
        minSdk = providers.gradleProperty("android.minSdk").get().toInt()
        targetSdk = providers.gradleProperty("android.targetSdk").get().toInt()
        versionCode = providers.gradleProperty("android.versionCode").get().toInt()
        versionName = providers.gradleProperty("android.versionName").get()
    }
    buildTypes {

        getByName("release") {
            isMinifyEnabled = false
        }
    }
}