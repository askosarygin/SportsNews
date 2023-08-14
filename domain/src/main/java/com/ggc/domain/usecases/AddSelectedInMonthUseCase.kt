package com.ggc.domain.usecases

import com.ggc.common.entities.SelectedInMonth
import com.ggc.common.entities.SelectedInMonthDB
import com.ggc.domain.Repository

class AddSelectedInMonthUseCase(
    private val repository: Repository
) {
    suspend fun execute(selectedInMonth: SelectedInMonth): Boolean {
        repository.deleteSelectedMonth()
        return repository.addSelectedInMonth(
            SelectedInMonthDB(
                monthNumber = selectedInMonth.monthNumber,
                yearNumber = selectedInMonth.yearNumber,
                selectedDayStart = selectedInMonth.selectedDayStartId,
                selectedDayEnd = selectedInMonth.selectedDayEndId
            )
        )
    }
}