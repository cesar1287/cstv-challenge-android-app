package com.github.cesar1287.challengecstv.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Opponent(
    val opponent: Team,
    val type: String
): Parcelable