package com.github.cesar1287.challengecstv.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchVO(
    var id: Int,
    var teamAId: Int,
    var teamAName: String,
    var teamAImageUrl: String?,
    var teamBId: Int,
    var teamBName: String,
    var teamBImageUrl: String?,
    var leagueName: String,
    var seriesName: String,
    var leagueImageUrl: String?,
    var matchStatus: MatchStatus,
    var datePretty: String
): Parcelable {

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<MatchVO> =
            object : DiffUtil.ItemCallback<MatchVO>() {
                override fun areItemsTheSame(oldItem: MatchVO, newItem: MatchVO): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: MatchVO, newItem: MatchVO): Boolean {
                    return oldItem == newItem
                }
            }
    }
}