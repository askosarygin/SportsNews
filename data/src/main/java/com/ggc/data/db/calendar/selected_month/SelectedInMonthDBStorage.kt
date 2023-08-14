package com.ggc.data.db.calendar.selected_month

import com.ggc.common.entities.SelectedInMonthDB


interface SelectedInMonthDBStorage {
    suspend fun add(selectedInMonthDB: SelectedInMonthDB): Boolean

    suspend fun deleteSelectedMonth(): Boolean

    suspend fun get(): SelectedInMonthDB
}