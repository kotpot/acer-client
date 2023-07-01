package com.korilin.pintask.shared.platform

import io.ktor.client.*
import io.ktor.client.engine.java.*


actual object Platform{
    actual val platform: String = "JvmDesktop"
    actual val ktorClient: HttpClient = HttpClient(Java)
}