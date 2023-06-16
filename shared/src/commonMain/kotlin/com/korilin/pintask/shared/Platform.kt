package com.korilin.pintask.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
