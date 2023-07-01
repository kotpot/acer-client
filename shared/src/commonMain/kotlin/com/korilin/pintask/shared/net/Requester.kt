@file:OptIn(ExperimentalSerializationApi::class)

package com.korilin.pintask.shared.net

import com.korilin.pintask.protocol.net.NetResponse
import com.korilin.pintask.shared.platform.Platform
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromHexString
import kotlinx.serialization.protobuf.ProtoBuf

object Requester {

    private val client = Platform.ktorClient

    suspend fun get(url: String, params: Map<String, Any?>): Result<NetResponse> = kotlin.runCatching {
        val urlWithParams = urlWithParams(url, params)
        val response = client.get(urlWithParams)
        ProtoBuf.decodeFromHexString(response.bodyAsText())
    }

    suspend fun post(url: String, params: Map<String, Any?>): Result<NetResponse> = kotlin.runCatching {
        val response = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(params)
        }
        ProtoBuf.decodeFromHexString(response.bodyAsText())
    }

    private fun urlWithParams(url: String, params: Map<String, Any?>): String {
        val urlBuilder = StringBuilder(url.plus("?"))
        for (param in params) {
            urlBuilder.append("${param.key}=${param.value}")
        }
        return urlBuilder.toString()
    }
}