package com.github.cesar1287.challengecstv.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Series(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("end_at")
    val endAt: String?,
    @SerializedName("full_name")
    val fullName: String,
    val id: Int,
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("modified_at")
    val modifiedAt: String,
    val name: String?,
    val season: String?,
    val slug: String,
    val year: Int
): Parcelable