package com.ggc.common.entities

import androidx.compose.ui.graphics.ImageBitmap
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale



data class MatchInfo(
    val id: Long = -1,
    val matchDate: Calendar = Calendar.getInstance().apply {
        set(1970, 0, 1, 0, 0, 0)
    },
    val teamOne: TeamInfo = TeamInfo(),
    val teamTwo: TeamInfo = TeamInfo(),
    val date: String = formatterDate.format(matchDate.time),
    val time: String = formatterTime.format(matchDate.time)
) {
    data class TeamInfo(
        val teamId: Long = -1L,
        val teamLogo: ImageBitmap? = null,
        val teamName: String = "",
    )

    companion object {
        val formatterDate = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)
        val formatterTime = SimpleDateFormat("HH:mm", Locale.ROOT)
    }
}
