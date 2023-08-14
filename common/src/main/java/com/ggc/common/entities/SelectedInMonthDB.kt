package com.ggc.common.entities

data class SelectedInMonthDB(
    val monthNumber: Int,
    val yearNumber: Int,
    val selectedDayStart: Int,
    val selectedDayEnd: Int
)
