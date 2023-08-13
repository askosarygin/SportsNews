package com.ggc.ui_calendar.screen_calendar

import androidx.lifecycle.viewModelScope
import com.ggc.common.entities.MonthInfo
import com.ggc.common.utils.SportsNewsViewModel
import com.ggc.common.utils.SportsNewsViewModelSingleLifeEvent
import com.ggc.domain.Interactor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenCalendarViewModel(
    private val interactor: Interactor
) : SportsNewsViewModel<ScreenCalendarViewModel.Model>(Model()) {
    init {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun buttonApplyPressed() {

    }

    fun buttonNextMonthPressed() {

    }

    fun buttonPreviousMonthPressed() {

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

    private fun updateCurrentMonth(currentMonth: MonthInfo) {
        update { it.copy(currentMonth = currentMonth) }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update { it.copy(navigationEvent = navigationEvent) }
    }
}