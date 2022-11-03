package com.github.cesar1287.challengecstv.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer dw71X6H0GoFMLx66nW5NXgLlB3MbhdasdcNT93bZs5DMfg3jmDA")
            .build()
        return chain.proceed(request)
    }
}