package com.ggc.ui_match.screen_match

import androidx.lifecycle.viewModelScope
import com.ggc.common.entities.MatchInfo
import com.ggc.common.utils.SportsNewsViewModel
import com.ggc.common.utils.SportsNewsViewModelSingleLifeEvent
import com.ggc.domain.Interactor
import com.ggc.ui_match.screen_match.ScreenMatchViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenHistory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenMatchViewModel(
    private val interactor: Interactor
) : SportsNewsViewModel<ScreenMatchViewModel.Model>(Model()) {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val matches = interactor.getAllMatches()
            updateMatches(matches)
        }
    }

    fun buttonHistoryPressed(teamId: Long) {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationInfo(ScreenHistory, teamId)
            )
        )
    }

    data class Model(
        val matches: List<MatchInfo> = listOf(),
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigationInfo: NavigationInfo
        ) : SportsNewsViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationInfo>(
            navigationInfo
        ) {
            data class NavigationInfo(
                val navigateTo: NavigationDestination,
                val selectedTeamId: Long
            )

            enum class NavigationDestination {
                ScreenHistory
            }
        }
    }

    private fun updateMatches(matches: List<MatchInfo>) {
        update { it.copy(matches = matches) }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update { it.copy(navigationEvent = navigationEvent) }
    }
}