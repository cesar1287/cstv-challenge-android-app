package com.github.cesar1287.challengecstv.features.home.data

import com.github.cesar1287.challengecstv.extensions.getPrettyDate
import com.github.cesar1287.challengecstv.model.Match
import com.github.cesar1287.challengecstv.model.MatchStatus
import com.github.cesar1287.challengecstv.model.MatchVO
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.STATUS_FINISHED
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.STATUS_NOT_PLAYED
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.STATUS_RUNNING
import javax.inject.Inject

interface HomeMapper {

    fun matchToMatchVO(match: Match): MatchVO
}

class HomeMapperImpl @Inject constructor(): HomeMapper {

    override fun matchToMatchVO(match: Match): MatchVO {
        val teamA = match.opponents.firstOrNull()?.opponent
        val teamB = match.opponents.lastOrNull()?.opponent
        return MatchVO(
            id = match.id,
            teamAId = teamA?.id ?: 0,
            teamAName = teamA?.name ?: "",
            teamAImageUrl = teamA?.imageUrl,
            teamBId = teamB?.id ?: 0,
            teamBName = teamB?.name ?: "",
            teamBImageUrl = teamB?.imageUrl,
            leagueName = match.league.name,
            leagueImageUrl = match.league.imageUrl,
            seriesName = match.serie.fullName,
            matchStatus = getMatchStatus(match.status),
            datePretty = match.beginAt.getPrettyDate()
        )
    }

    private fun getMatchStatus(status: String) =
        when(status) {
            STATUS_FINISHED,
            STATUS_NOT_PLAYED -> MatchStatus.FINISHED
            STATUS_RUNNING -> MatchStatus.RUNNING
            else -> MatchStatus.NOT_STARTED
        }
}