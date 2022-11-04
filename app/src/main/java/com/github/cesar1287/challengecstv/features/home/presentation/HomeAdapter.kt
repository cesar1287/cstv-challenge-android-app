package com.github.cesar1287.challengecstv.features.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.databinding.MatchItemBinding
import com.github.cesar1287.challengecstv.model.Match
import com.github.cesar1287.challengecstv.utils.GlideApp

class HomeAdapter :
    PagingDataAdapter<Match, HomeViewHolder>(Match.DIFF_CALLBACK) {

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

    fun bind(match: Match?) {
        with(binding) {
            val teamA = match?.opponents?.first()?.opponent
            val teamB = match?.opponents?.last()?.opponent

            tvMatchLeagueSeries.text = itemView.context.getString(
                R.string.league_series_label,
                match?.league?.name,
                match?.serie?.fullName
            )

            tvMatchTeamA.text = teamA?.name
            tvMatchTeamB.text = teamB?.name

            GlideApp.with(itemView.context).load(teamA?.imageUrl).into(ivMatchTeamA)
            GlideApp.with(itemView.context).load(teamB?.imageUrl).into(ivMatchTeamB)
            GlideApp.with(itemView.context).load(match?.league?.imageUrl).into(ivMatchLeagueSeries)
        }
    }
}