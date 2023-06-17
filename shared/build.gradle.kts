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
    macosX64()
    macosArm64()
    mingwX64()


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutinues.core)
                implementation(libs.kotlinx.serialization.json)
            }
        }
        val androidMain by getting
        val iosMain by getting
        val desktopMain by getting
        val macosX64Main by getting {
            dependsOn(desktopMain)
        }
        val mingwX64Main by getting {
            dependsOn(desktopMain)
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