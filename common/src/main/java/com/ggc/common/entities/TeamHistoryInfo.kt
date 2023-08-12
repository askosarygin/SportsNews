package com.ggc.common.entities

import androidx.compose.ui.graphics.ImageBitmap

data class TeamHistoryInfo(
    val teamId: Long = -1L,
    val teamLogo: ImageBitmap? = null,
    val teamName: String = "",
    val matches: List<Match> = listOf(),
    val statistics: Statistics = Statistics()
) {
    data class Match(
        val rivalLogo: ImageBitmap? = null,
        val rivalName: String = "",
        val duration: String = "",
        val date: String = "",
        val time: String = ""
    )

    data class Statistics(
        val amount: Amount = Amount(),
        val all: All = All(),
        val average: Average = Average()
    ) {
        data class Amount(
            val victory: String = "",
            val draws: String = "",
            val defeats: String = "",
            val scorePoints: String = "",
            val goalsScored: String = "",
            val missedGoals: String = "",
            val ballDifferential: String = "",
            val viewers: String = "",
            val _2xPR: String = "",
            val _3xPR: String = "",
            val _1xPR: String = "",
            val pickingsAttack: String = "",
            val pickingsDefense: String = "",
            val selectionsTotal: String = "",
            val transmissions: String = "",
            val intercepts: String = "",
            val losses: String = "",
            val blockchain: String = "",
            val fouls: String = "",
            val foulsOfTheOpponent: String = "",
            val utilityFactor: String = ""
        )

        data class All(
            val matchesPlayed: String = "",
            val _2xPercent: String = "",
            val _3xPercent: String = "",
            val _1xPercent: String = ""
        )

        data class Average(
            val victory: String = "",
            val draws: String = "",
            val defeats: String = "",
            val scorePoints: String = "",
            val goalsScored: String = "",
            val missedGoals: String = "",
            val ballDifferential: String = "",
            val viewers: String = "",
            val _2xPR: String = "",
            val _3xPR: String = "",
            val _1xPR: String = "",
            val pickingsAttack: String = "",
            val pickingsDefense: String = "",
            val selectionsTotal: String = "",
            val transmissions: String = "",
            val intercepts: String = "",
            val losses: String = "",
            val blockchain: String = "",
            val fouls: String = "",
            val foulsOfTheOpponent: String = "",
            val utilityFactor: String = ""
        )
    }
}
