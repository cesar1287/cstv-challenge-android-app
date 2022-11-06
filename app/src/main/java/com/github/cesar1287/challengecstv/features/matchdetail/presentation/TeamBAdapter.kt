package com.github.cesar1287.challengecstv.features.matchdetail.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.databinding.TeamBItemBinding
import com.github.cesar1287.challengecstv.model.Player
import com.github.cesar1287.challengecstv.utils.GlideApp

class TeamBAdapter :
    ListAdapter<Player, TeamBAdapter.TeamBViewHolder>(Player.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamBViewHolder {
        val binding = TeamBItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamBViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamBViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TeamBViewHolder(
        private val binding: TeamBItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            player: Player?
        ) = with(binding) {
            player?.let {
                tvTeamPlayerName.text = player.first_name
                tvTeamPlayerNickname.text = player.name
                GlideApp.with(itemView.context)
                    .load(player.image_url)
                    .error(R.drawable.no_logo)
                    .into(ivTeamPlayerFrame)
            }
        }
    }
}