package com.korilin.pintask.shared.platform

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class IosKtorNetRequester : NetRequester {

    private val client = HttpClient()

    override suspend fun <O> get(url: String, params: Map<String, Any?>): Result<O> {
//        return kotlin.runCatching {
//            val urlWithParams = urlWithParams(url, params)
//            val response = client.get(urlWithParams)
//            response.bodyAsText()
//        }
        TODO()
    }

    override suspend fun <I, O>  post(
        url: String,
        params: I
    ): Result<O> {
         return kotlin.runCatching {
            val response = client.post(url) {
                contentType(ContentType.Application.Json)
                setBody(body)
            }
            //response.body(TypeInfo(I::class))
            TODO()
        }
    }

}