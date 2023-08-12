package com.ggc.ui_news.screen_news_list

import androidx.lifecycle.viewModelScope
import com.ggc.common.entities.NewsInfo
import com.ggc.common.utils.SportsNewsViewModel
import com.ggc.common.utils.SportsNewsViewModelSingleLifeEvent
import com.ggc.domain.Interactor
import com.ggc.ui_news.screen_news_list.ScreenNewsListViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenNewsArticle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenNewsListViewModel(
    private val interactor: Interactor
) : SportsNewsViewModel<ScreenNewsListViewModel.Model>(Model()) {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val news = interactor.getAllNews()
            updateNews(news)
        }
    }

    fun newsClicked(newsId: Long) {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationInfo(
                    ScreenNewsArticle,
                    newsId
                )
            )
        )
    }

    data class Model(
        val news: List<NewsInfo> = listOf(),
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigationInfo: NavigationInfo
        ) : SportsNewsViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationInfo>(
            navigationInfo
        ) {
            data class NavigationInfo(
                val navigateTo: NavigationDestination,
                val selectedNewsId: Long
            )

            enum class NavigationDestination {
                ScreenNewsArticle
            }
        }
    }

    private fun updateNews(news: List<NewsInfo>) {
        update { it.copy(news = news) }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update { it.copy(navigationEvent = navigationEvent) }
    }
}