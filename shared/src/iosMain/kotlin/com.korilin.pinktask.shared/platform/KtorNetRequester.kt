package com.korilin.pinktask.shared.platform

import com.korilin.pintask.shared.platform.NetRequester
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

//class KtorNetRequester : NetRequester {
//
//    private val client = HttpClient()
//
//    override suspend fun get(url: String, params: Map<String, Any?>): Result<String> {
//        return kotlin.runCatching {
//            val urlWithParams = urlWithParams(url, params)
//            val response = client.get(urlWithParams)
//            response.bodyAsText()
//        }
//    }
//
//    override suspend fun <T> post(
//        url: String,
//        params: T,
//        serializer: KSerializer<T>
//    ): Result<String> {
//        return kotlin.runCatching {
//            val response = client.post(url) {
//                contentType(ContentType.Application.Json)
//                val body = Json.encodeToString(serializer, params)
//                setBody(body)
//            }
//            response.bodyAsText()
//        }
//    }
//}