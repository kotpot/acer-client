plugins {
    id("com.android.application")
    kotlin("android")
}

group = "com.korilin.pintask"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
}

android {
    namespace = "com.korilin.pintask.android"
    compileSdk = 32
    defaultConfig {
        applicationId = "com.korilin.pintask.android"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}