package com.github.cesar1287.challengecstv.features.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.databinding.MatchItemBinding
import com.github.cesar1287.challengecstv.model.MatchStatus
import com.github.cesar1287.challengecstv.model.MatchVO
import com.github.cesar1287.challengecstv.utils.GlideApp

class HomeAdapter :
    PagingDataAdapter<MatchVO, HomeViewHolder>(MatchVO.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            MatchItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeViewHolder(
    private val binding: MatchItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(matchVO: MatchVO?) {
        with(binding) {
            tvMatchLeagueSeries.text = itemView.context.getString(
                R.string.league_series_label,
                matchVO?.leagueName,
                matchVO?.seriesName
            )

            tvMatchTeamA.text = matchVO?.teamAName
            tvMatchTeamB.text = matchVO?.teamBName

            GlideApp.with(itemView.context).load(matchVO?.teamAImageUrl).into(ivMatchTeamA)
            GlideApp.with(itemView.context).load(matchVO?.teamBImageUrl).into(ivMatchTeamB)
            GlideApp.with(itemView.context).load(matchVO?.leagueImageUrl).into(ivMatchLeagueSeries)

            when(matchVO?.matchStatus) {
                MatchStatus.RUNNING -> {
                    ivMatchLiveNow.isVisible = true
                    ivMatchDate.isVisible = false
                    tvMatchDate.isVisible = false
                }
                else -> {
                    ivMatchLiveNow.isVisible = false
                    ivMatchDate.isVisible = true
                    tvMatchDate.isVisible = true
                    tvMatchDate.text = matchVO?.datePretty
                }
            }
        }
    }
}