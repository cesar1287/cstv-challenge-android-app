package com.github.cesar1287.challengecstv.model

data class Tournament(
    val begin_at: String,
    val end_at: String?,
    val id: Int,
    val league_id: Int,
    val live_supported: Boolean,
    val modified_at: String,
    val name: String,
    val prizepool: String?,
    val serie_id: Int,
    val slug: String,
    val tier: String,
    val winner_id: Any?,
    val winner_type: String
)