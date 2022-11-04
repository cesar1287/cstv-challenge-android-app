package com.github.cesar1287.challengecstv.features.matchdetail.domain

import com.github.cesar1287.challengecstv.utils.ResponseApi

interface MatchDetailUseCase {

    suspend fun getTeams(teamAId: Int, teamBId: Int): ResponseApi
}

class MatchDetailUseCaseImpl: MatchDetailUseCase {

    override suspend fun getTeams(teamAId: Int, teamBId: Int): ResponseApi {
        TODO("Not yet implemented")
    }

}