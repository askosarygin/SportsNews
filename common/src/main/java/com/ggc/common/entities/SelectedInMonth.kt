package com.ggc.common.entities

data class SelectedInMonth(
    val monthNumber: Int,
    val yearNumber: Int,
    val selectedDayStartId: Int,
    val selectedDayEndId: Int
)
