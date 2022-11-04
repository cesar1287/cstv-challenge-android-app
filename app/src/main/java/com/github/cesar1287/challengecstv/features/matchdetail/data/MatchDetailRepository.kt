package com.github.cesar1287.challengecstv.features.matchdetail.data

import com.github.cesar1287.challengecstv.api.PandaScoreApi
import com.github.cesar1287.challengecstv.base.BaseRepository
import com.github.cesar1287.challengecstv.utils.ResponseApi
import javax.inject.Inject

interface MatchDetailRepository {

    suspend fun getTeams(teams: String): ResponseApi
}

class MatchDetailRepositoryImpl @Inject constructor(
    private val pandaScoreApi: PandaScoreApi
): MatchDetailRepository, BaseRepository() {

    override suspend fun getTeams(teams: String) =
        safeApiCall {
            pandaScoreApi.getTeams(teams)
        }

}
