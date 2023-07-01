package com.korilin.pintask.shared.platform

import io.ktor.client.*

expect object Platform{
    val platform: String
    val ktorClient: HttpClient
}