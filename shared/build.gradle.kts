plugins {
    kotlin("multiplatform")
    id("com.android.application")
}

group = "com.korilin.pintask"
version = "1.0-SNAPSHOT"

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
                implementation("junit:junit:4.13.2")
            }
        }
        val macosX64Main by getting
        val macosX64Test by getting
    }
}

android {
    namespace = "com.korilin.pintask.shared"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.korilin.pintask.shared"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}