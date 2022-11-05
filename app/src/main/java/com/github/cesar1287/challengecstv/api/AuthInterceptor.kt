package com.github.cesar1287.challengecstv.api

import com.github.cesar1287.challengecstv.BuildConfig
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.AUTHORIZATION_FIELD
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(AUTHORIZATION_FIELD, "Bearer ${BuildConfig.API_TOKEN}")
            .build()
        return chain.proceed(request)
    }
}