package com.ggc.ui_calendar.screen_calendar

import androidx.lifecycle.viewModelScope
import com.ggc.common.entities.MonthInfo
import com.ggc.common.entities.SelectedInMonth
import com.ggc.common.utils.SportsNewsViewModel
import com.ggc.common.utils.SportsNewsViewModelSingleLifeEvent
import com.ggc.domain.Interactor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class ScreenCalendarViewModel(
    private val interactor: Interactor
) : SportsNewsViewModel<ScreenCalendarViewModel.Model>(Model()) {
    private var countSelectedDays = 0

    init {
        viewModelScope.launch(Dispatchers.IO) {

            val currentMonth = interactor.getMonthInfo(
                Calendar.getInstance().apply {
                    set(2023, 1, 1)
                }
            )
            updateCurrentMonth(currentMonth)
        }
    }

    fun buttonApplyPressed() {
        viewModelScope.launch(Dispatchers.IO) {
            if (countSelectedDays == -1) {
                val firstSelectedDayId = model.value.currentMonth.dayCells.find {
                    it.dayInfo?.selection?.start ?: false
                }!!.id
                val lastSelectedDayId = model.value.currentMonth.dayCells.find {
                    it.dayInfo?.selection?.end ?: false
                }!!.id

                interactor.addSelectedInMonth(
                    SelectedInMonth(
                        monthNumber = model.value.currentMonth.monthDate.get(Calendar.MONTH),
                        yearNumber = model.value.currentMonth.monthDate.get(Calendar.YEAR),
                        selectedDayStartId = firstSelectedDayId,
                        selectedDayEndId = lastSelectedDayId
                    )
                )

                for (id in firstSelectedDayId .. lastSelectedDayId) {
                    updateDaySelectionById(
                        id,
                        MonthInfo.DayCell.DayInfo.Selection()
                    )
                }

                countSelectedDays = 0
            }
        }
    }

    fun dayClicked(dayId: Int) {
        model.value.currentMonth.dayCells[dayId].dayInfo?.selection?.let { daySelection ->
            if (countSelectedDays == 0) {
                updateDaySelectionById(
                    dayId,
                    daySelection.copy(start = true)
                )
                countSelectedDays = 1
            } else {
                if (countSelectedDays == 1) {
                    updateDaySelectionById(
                        dayId,
                        daySelection.copy(end = true)
                    )
                    countSelectedDays = 2
                }

                if (countSelectedDays == 2) {
                    val firstSelectedDayId = model.value.currentMonth.dayCells.find {
                        it.dayInfo?.selection?.start ?: false
                    }!!.id

                    val lastSelectedDayId = model.value.currentMonth.dayCells.find {
                        it.dayInfo?.selection?.end ?: false
                    }!!.id

                    for (id in firstSelectedDayId + 1 until lastSelectedDayId) {
                        updateDaySelectionById(
                            id,
                            model.value.currentMonth.dayCells[id].dayInfo!!.selection.copy(
                                intermediate = true
                            )
                        )
                    }

                    countSelectedDays = -1
                } else {
                    if (countSelectedDays == -1) {
                        val firstSelectedDayId = model.value.currentMonth.dayCells.find {
                            it.dayInfo?.selection?.start ?: false
                        }!!.id
                        val lastSelectedDayId = model.value.currentMonth.dayCells.find {
                            it.dayInfo?.selection?.end ?: false
                        }!!.id
                        for (id in firstSelectedDayId .. lastSelectedDayId) {
                            updateDaySelectionById(
                                id,
                                MonthInfo.DayCell.DayInfo.Selection()
                            )
                        }

                        updateDaySelectionById(
                            dayId,
                            daySelection.copy(start = true)
                        )
                        countSelectedDays = 1
                    }
                }
            }
        }
    }

    fun buttonNextMonthPressed() {
        viewModelScope.launch(Dispatchers.IO) {
            val nextMonth = model.value.currentMonth.monthDate.apply { add(Calendar.MONTH, 1) }
            val newCurrentMonth = interactor.getMonthInfo(nextMonth)
            updateCurrentMonth(newCurrentMonth)
            countSelectedDays = 0
        }
    }

    fun buttonPreviousMonthPressed() {
        viewModelScope.launch(Dispatchers.IO) {
            val previousMonth = model.value.currentMonth.monthDate.apply { add(Calendar.MONTH, -1) }
            val newCurrentMonth = interactor.getMonthInfo(previousMonth)
            updateCurrentMonth(newCurrentMonth)
            countSelectedDays = 0
        }
    }

    data class Model(
        val currentMonth: MonthInfo = MonthInfo(),
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : SportsNewsViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {

            }
        }
    }

    private fun updateDaySelectionById(
        dayId: Int,
        selection: MonthInfo.DayCell.DayInfo.Selection
    ) {
        update {
            it.copy(
                currentMonth = model.value.currentMonth.copy(
                    dayCells = model.value.currentMonth.dayCells.toMutableList().apply {
                        removeAt(dayId)
                        add(
                            dayId, model.value.currentMonth.dayCells[dayId].copy(
                                dayInfo = model.value.currentMonth.dayCells[dayId].dayInfo?.copy(
                                    selection = selection
                                )
                            )
                        )
                    }
                )
            )
        }
    }

    private fun updateCurrentMonth(currentMonth: MonthInfo) {
        update { it.copy(currentMonth = currentMonth) }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update { it.copy(navigationEvent = navigationEvent) }
    }
}