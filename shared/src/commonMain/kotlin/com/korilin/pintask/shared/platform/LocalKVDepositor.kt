package com.korilin.pintask.shared.platform

interface LocalKVDepositor {

    fun init()

    fun <T> put(key: String, value: T)

    fun <T> get(key: String): T

}