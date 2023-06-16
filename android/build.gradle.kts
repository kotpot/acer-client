plugins {
    kotlin("android")
    id("com.android.application")
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
}

android {
    namespace = providers.gradleProperty("android.app.id").get()
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