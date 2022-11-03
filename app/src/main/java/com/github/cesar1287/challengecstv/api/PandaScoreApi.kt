package com.github.cesar1287.challengecstv.api

import com.github.cesar1287.challengecstv.model.Matches
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PandaScoreApi {

    @GET("csgo/matches")
    suspend fun getMatches(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("range[begin_at]") range: Pair<String, String>,
        @Query("sort") sortList: List<String>
    ): Response<Matches>
}