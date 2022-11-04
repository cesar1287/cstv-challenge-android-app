package com.github.cesar1287.challengecstv.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    @SerializedName("begin_at")
    val beginAt: String,
    val id: Int,
    val league: League,
    val name: String,
    val opponents: List<Opponent>,
    @SerializedName("scheduled_at")
    val scheduledAt: String,
    val serie: Series,
    val status: String,
): Parcelable {

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<Match> =
            object : DiffUtil.ItemCallback<Match>() {
                override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
                    return oldItem == newItem
                }
        }
    }
}