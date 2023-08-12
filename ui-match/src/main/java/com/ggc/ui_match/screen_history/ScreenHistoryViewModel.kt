package com.ggc.ui_match.screen_history

import androidx.lifecycle.viewModelScope
import com.ggc.common.entities.TeamHistoryInfo
import com.ggc.common.navigation.NavArgs
import com.ggc.common.utils.SportsNewsViewModel
import com.ggc.common.utils.SportsNewsViewModelSingleLifeEvent
import com.ggc.domain.Interactor
import com.ggc.ui_match.screen_history.ScreenHistoryViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenMatch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenHistoryViewModel(
    private val navArg: NavArgs.ScreenHistory?,
    private val interactor: Interactor
) : SportsNewsViewModel<ScreenHistoryViewModel.Model>(Model()) {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            navArg?.let {
                val teamHistoryInfo = interactor.getTeamHistoryInfoById(it.teamId)
                updateTeamHistoryInfo(teamHistoryInfo)
            }
        }
    }

    fun buttonBackPressed() {
        updateNavigationEvent(Model.NavigationSingleLifeEvent(ScreenMatch))
    }

    data class Model(
        val teamHistoryInfo: TeamHistoryInfo = TeamHistoryInfo(),
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : SportsNewsViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {
                ScreenMatch
            }
        }
    }

    private fun updateTeamHistoryInfo(teamHistoryInfo: TeamHistoryInfo) {
        update { it.copy(teamHistoryInfo = teamHistoryInfo) }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update { it.copy(navigationEvent = navigationEvent) }
    }
}