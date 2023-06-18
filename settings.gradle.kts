pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "PinTask-client"


include(":shared")
include(":android")
include(":protocol")
