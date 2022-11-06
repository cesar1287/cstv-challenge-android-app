package com.github.cesar1287.challengecstv.features.matchdetail.data

import com.github.cesar1287.challengecstv.api.PandaScoreApi
import com.github.cesar1287.challengecstv.base.BaseRepository
import com.github.cesar1287.challengecstv.model.TeamsResponse
import com.github.cesar1287.challengecstv.model.TeamsVO
import com.github.cesar1287.challengecstv.utils.ResponseApi
import javax.inject.Inject

interface MatchDetailRepository {

    suspend fun getTeams(teams: String): ResponseApi
}

class MatchDetailRepositoryImpl @Inject constructor(
    private val pandaScoreApi: PandaScoreApi,
    private val matchDetailMapper: MatchDetailMapper
): MatchDetailRepository, BaseRepository() {

    override suspend fun getTeams(teams: String): ResponseApi {
        val response = safeApiCall {
            pandaScoreApi.getTeams(teams)
        }
        return when(response) {
            is ResponseApi.Success -> {
                val teamsResponse = response.data as? TeamsResponse
                response.data = teamsResponse?.let {
                     matchDetailMapper.teamsToTeamsVO(teamsResponse)
                } ?: TeamsVO(
                    teamA = null,
                    teamB = null,
                    noTeamsResponse = true
                )
                response
            }
            is ResponseApi.Error -> response
        }
    }
}
