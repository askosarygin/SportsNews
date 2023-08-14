package com.ggc.data.db.calendar.selected_month

import android.util.Log
import com.ggc.common.entities.SelectedInMonthDB

class SelectedInMonthDBStorageImpl(
    private val selectedInMonthDAO: SelectedInMonthDAO
): SelectedInMonthDBStorage {
    override suspend fun add(selectedInMonthDB: SelectedInMonthDB): Boolean {
        Log.i("MY_TAG", "зашло")

        selectedInMonthDAO.add(
            SelectedInMonthDatabaseClass(
                0L,
                selectedInMonthDB.monthNumber,
                selectedInMonthDB.yearNumber,
                selectedInMonthDB.selectedDayStart,
                selectedInMonthDB.selectedDayEnd
            )
        )
        return true
    }

    override suspend fun deleteSelectedMonth(): Boolean {
        selectedInMonthDAO.delete()
        return true
    }

    override suspend fun get(): SelectedInMonthDB {
        val selectedMonth = selectedInMonthDAO.get()
        return if (selectedMonth != null) {
            SelectedInMonthDB(
                selectedMonth.monthNumber,
                selectedMonth.yearNumber,
                selectedMonth.selectedDayStart,
                selectedMonth.selectedDayEnd
            )
        } else {
            SelectedInMonthDB(
                -1,
                -1,
                -1,
                -1,
            )
        }

    }
}