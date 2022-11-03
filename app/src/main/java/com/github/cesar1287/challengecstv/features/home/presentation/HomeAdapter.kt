package com.github.cesar1287.challengecstv.features.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.databinding.MatchItemBinding
import com.github.cesar1287.challengecstv.model.Match

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
            tvMatchTeamA.text = itemView.context.getString(
                R.string.league_series_label,
                match?.league?.name,
                match?.serie?.full_name
            )

            tvMatchTeamA.text = match?.opponents?.first()?.opponent?.name
            tvMatchTeamB.text = match?.opponents?.last()?.opponent?.name
        }
    }
}