package com.github.cesar1287.challengecstv.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamsResponseItem(
    val id: Int,
    val players: List<Player>
): Parcelable