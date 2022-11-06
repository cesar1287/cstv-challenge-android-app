package com.github.cesar1287.challengecstv.features.matchdetail.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.challengecstv.R
import com.github.cesar1287.challengecstv.databinding.TeamAItemBinding
import com.github.cesar1287.challengecstv.model.Player
import com.github.cesar1287.challengecstv.utils.GlideApp

class TeamAAdapter :
    ListAdapter<Player, TeamAAdapter.TeamAViewHolder>(Player.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAViewHolder {
        val binding = TeamAItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamAViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamAViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TeamAViewHolder(
        private val binding: TeamAItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            player: Player?
        ) = with(binding) {
            player?.let {
                tvTeamPlayerName.text =  player.first_name
                tvTeamPlayerNickname.text = player.name
                GlideApp.with(itemView.context)
                    .load(player.image_url)
                    .error(R.drawable.no_logo)
                    .into(ivTeamPlayerFrame)
            }
        }
    }
}