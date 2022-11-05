package com.github.cesar1287.challengecstv.base

import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.utils.ResponseApi
import retrofit2.Response

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>) = safeApiResult(call)

    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>) : ResponseApi {
        return try {
            val response = call.invoke()

            if(response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                ResponseApi.Error(R.string.error_default)
            }
        } catch (error : Exception) {
            ResponseApi.Error(R.string.error_default)
        }
    }
}