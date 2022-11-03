package com.github.cesar1287.challengecstv.features.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.databinding.MatchItemBinding
import com.github.cesar1287.challengecstv.model.Match
import com.github.cesar1287.challengecstv.utils.GlideApp

class HomeAdapter : PagingDataAdapter<Match, MoviePosterViewHolder>(MovieDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePosterViewHolder {
        return MoviePosterViewHolder(
            MatchItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviePosterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MovieDiffCallBack : DiffUtil.ItemCallback<Match>() {
    override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem == newItem
    }
}

class MoviePosterViewHolder(
    private val binding: MatchItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(match: Match?) {
        with(binding) {
            val teamA = match?.opponents?.first()?.opponent
            val teamB = match?.opponents?.last()?.opponent

            tvMatchLeagueSeries.text = itemView.context.getString(
                R.string.league_series_label,
                match?.league?.name,
                match?.serie?.full_name
            )

            tvMatchTeamA.text = teamA?.name
            tvMatchTeamB.text = teamB?.name

            GlideApp.with(itemView.context).load(teamA?.image_url).into(ivMatchTeamA)
            GlideApp.with(itemView.context).load(teamB?.image_url).into(ivMatchTeamB)
            GlideApp.with(itemView.context).load(match?.league?.image_url).into(ivMatchLeagueSeries)
        }
    }
}