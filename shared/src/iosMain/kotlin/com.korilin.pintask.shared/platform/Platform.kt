package com.korilin.pintask.shared.platform

import io.ktor.client.*

actual object Platform{
    actual val platform: String = "iOS"
    actual val ktorClient: HttpClient = HttpClient()
}