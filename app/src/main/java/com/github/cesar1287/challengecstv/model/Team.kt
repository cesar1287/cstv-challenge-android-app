package com.github.cesar1287.challengecstv.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String?,
    val location: String?,
    @SerializedName("modified_at")
    val modifiedAt: String,
    val name: String,
    val slug: String
): Parcelable