package com.ggc.common.entities

data class MonthInfo(
    val month: String = "",
    val year: String = "",
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
}