package com.github.cesar1287.challengecstv.model

data class Match(
    val begin_at: String,
    val id: Int,
    val league: League,
    val name: String,
    val opponents: List<Opponent>,
    val scheduled_at: String,
    val serie: Series,
    val status: String,
)