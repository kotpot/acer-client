package com.korilin.pintask.shared.platform

import kotlinx.serialization.KSerializer

interface NetRequester {
    suspend fun <O> get(url: String, params: Map<String, Any?>): Result<O>

    suspend fun <I, O> post(url: String, params: I): Result<O>

    fun urlWithParams(url: String, params: Map<String, Any?>): String {
        val urlBuilder = StringBuilder(url.plus("?"))
        for (param in params) {
            urlBuilder.append("${param.key}=${param.value}")
        }
        return urlBuilder.toString()
    }
}