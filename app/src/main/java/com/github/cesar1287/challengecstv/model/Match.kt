package com.github.cesar1287.challengecstv.model

data class Match(
    val begin_at: String,
    val id: Int,
    val league: League,
    val match_type: String,
    val modified_at: String,
    val name: String,
    val number_of_games: Int,
    val opponents: List<Opponent>,
    val original_scheduled_at: String,
    val rescheduled: Boolean,
    val scheduled_at: String,
    val serie: Serie,
    val serie_id: Int,
    val slug: String,
    val status: String,
)