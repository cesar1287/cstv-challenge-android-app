package com.github.cesar1287.challengecstv.features.matchdetail.domain

import com.github.cesar1287.challengecstv.features.matchdetail.data.MatchDetailRepository
import com.github.cesar1287.challengecstv.utils.ResponseApi
import javax.inject.Inject

interface MatchDetailUseCase {

    suspend fun getTeams(teamAId: Int, teamBId: Int): ResponseApi
}

class MatchDetailUseCaseImpl @Inject constructor(
    private val matchDetailRepository: MatchDetailRepository
): MatchDetailUseCase {

    override suspend fun getTeams(teamAId: Int, teamBId: Int) =
        matchDetailRepository.getTeams("$teamBId,$teamAId")
}