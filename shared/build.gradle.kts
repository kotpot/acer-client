plugins {
    kotlin("multiplatform")
    id("com.android.application")
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

kotlin {
    android()
    macosX64()
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(libs.junit)
            }
        }
        val macosX64Main by getting
        val macosX64Test by getting
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