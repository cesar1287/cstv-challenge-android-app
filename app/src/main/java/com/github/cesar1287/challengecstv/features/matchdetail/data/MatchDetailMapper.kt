package com.github.cesar1287.challengecstv.features.matchdetail.data

import com.github.cesar1287.challengecstv.model.TeamsResponse
import com.github.cesar1287.challengecstv.model.TeamsVO
import javax.inject.Inject

interface MatchDetailMapper {

    fun teamsToTeamsVO(teamsResponse: TeamsResponse): TeamsVO
}

class MatchDetailMapperImpl @Inject constructor(): MatchDetailMapper {

    override fun teamsToTeamsVO(teamsResponse: TeamsResponse): TeamsVO {
        return TeamsVO(
            teamA = teamsResponse.firstOrNull()?.players,
            teamB = teamsResponse.lastOrNull()?.players,
            noTeamsResponse = teamsResponse.firstOrNull()?.players?.isEmpty() == true &&
                    teamsResponse.lastOrNull()?.players?.isEmpty() == true
        )
    }

}