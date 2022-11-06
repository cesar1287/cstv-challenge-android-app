package com.github.cesar1287.challengecstv.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamsVO(
    val teamA: List<Player>?,
    val teamB: List<Player>?,
    val noTeamsResponse: Boolean,
    val firstTeamId: Int?,
    val secondTeamId: Int?
): Parcelable