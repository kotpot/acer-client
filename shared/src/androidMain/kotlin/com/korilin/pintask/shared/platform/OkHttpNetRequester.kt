package com.korilin.pintask.shared.platform

import android.util.Log
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class OkHttpNetRequester : NetRequester {

    private val client = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    private fun requestBuilder(url: String) = Request.Builder().url(url)

    private val mediaType = "application/json".toMediaType()

    override suspend fun get(
        url: String,
        params: Map<String, Any?>
    ): Result<String> {
        Log.d("OkHttpNetRequester", "get:: $url $params")
        val urlWithParams = urlWithParams(url, params)
        val request = requestBuilder(urlWithParams).get().build()
        return doRequest(request)
    }

    override suspend fun <T> post(
        url: String,
        params: T,
        serializer: KSerializer<T>
    ): Result<String> {
        val json = Json.encodeToString(serializer, params)
        val body = json.toRequestBody(mediaType)
        Log.d("OkHttpNetRequester", "post:: $url $json")
        val request = requestBuilder(url).post(body).build()
        return doRequest(request)
    }

    private suspend fun doRequest(request: Request): Result<String> = suspendCoroutine {
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("OkHttpNetRequester", e.stackTraceToString())
                it.resume(Result.failure(e))
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string() ?: "{}"
                Log.d("OkHttpNetRequester", "response:: $body.")
                it.resume(Result.success(body))
            }
        })
    }
}