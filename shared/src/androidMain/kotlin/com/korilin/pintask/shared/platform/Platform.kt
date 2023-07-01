package com.korilin.pintask.shared.platform

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*

actual object Platform{
    actual val platform: String = "Android"
    actual val ktorClient: HttpClient = HttpClient(OkHttp)
}