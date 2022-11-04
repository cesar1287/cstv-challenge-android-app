package com.github.cesar1287.challengecstv.api

import com.github.cesar1287.challengecstv.model.MatchesResponse
import com.github.cesar1287.challengecstv.model.TeamsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PandaScoreApi {

    @GET("csgo/matches")
    suspend fun getMatches(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("range[begin_at]") range: String,
        @Query("sort") sort: String
    ): MatchesResponse

    @GET("csgo/teams")
    suspend fun getTeams(
        @Query("filter[id]") teams: String,
    ): Response<TeamsResponse>
}