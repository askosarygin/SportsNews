package com.ggc.common.entities

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class MonthInfo(
    val monthDate: Calendar = Calendar.getInstance().apply {
        set(1970, 0, 1, 0, 0, 0)
    },
    val month: String = when (monthDate.get(Calendar.MONTH)) {
        0 -> "January"
        1 -> "February"
        2 -> "March"
        3 -> "April"
        4 -> "May"
        5 -> "June"
        6 -> "July"
        7 -> "August"
        8 -> "September"
        9 -> "October"
        10 -> "November"
        11 -> "December"
        else -> "January"
    },
    val year: String = formatterYear.format(monthDate.time),
    val dayCells: List<DayCell> = listOf()
) {
    data class DayCell(
        val id: Int,
        val dayInfo: DayInfo? = null
    ) {
        data class DayInfo(
            val number: String = "",
            val selection: Selection = Selection()
        ) {
            data class Selection(
                val start: Boolean = false,
                val intermediate: Boolean = false,
                val end: Boolean = false
            )
        }
    }

    companion object {
        val formatterYear = SimpleDateFormat("yyyy", Locale.ROOT)
    }
}