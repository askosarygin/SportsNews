package com.ggc.domain.usecases

import com.ggc.common.entities.SelectedInMonth
import com.ggc.domain.Repository

class GetSelectedInMonthUseCase(
    private val repository: Repository
) {
    suspend fun execute(): SelectedInMonth {
        val selectedMonthDB = repository.getSelectedInMonth()
        return SelectedInMonth(
            selectedMonthDB.monthNumber,
            selectedMonthDB.yearNumber,
            selectedMonthDB.selectedDayStart,
            selectedMonthDB.selectedDayEnd,
        )
    }
}