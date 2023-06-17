package com.korilin.pintask.shared.platform

import com.korilin.pintask.shared.model.ResponseBody
import com.korilin.pintask.shared.platform.NetRequester
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.reflect.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class KtorNetRequester : NetRequester {

    private val client = HttpClient()

    override suspend fun <O> get(url: String, params: Map<String, Any?>): Result<O> {
        return kotlin.runCatching {
            val urlWithParams = urlWithParams(url, params)
            val response = client.get(urlWithParams)
            response.bodyAsText()
        }
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
             response.body(TypeInfo(I::class))
        }
    }

}