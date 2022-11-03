package com.github.cesar1287.challengecstv.model

data class Match(
    val begin_at: String,
    val detailed_stats: Boolean,
    val draw: Boolean,
    val end_at: String?,
    val forfeit: Boolean,
    val game_advantage: Any?,
    val games: List<Game>,
    val id: Int,
    val league: League,
    val league_id: Int,
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
    val streams_list: List<Streams>,
    val tournament: Tournament,
    val tournament_id: Int
)