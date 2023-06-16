buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.android.tools.build)
    }
}

group = providers.gradleProperty("group").get()
version = providers.gradleProperty("version").get()

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
