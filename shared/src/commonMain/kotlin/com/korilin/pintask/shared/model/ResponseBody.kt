package com.korilin.pintask.shared.model

data class ResponseBody<T>(
    val code: Int,
    val data: T?,
    val msg: String?
) {

    val isSuccess get() = code == 1

    val isFailure get() = code != 1

}