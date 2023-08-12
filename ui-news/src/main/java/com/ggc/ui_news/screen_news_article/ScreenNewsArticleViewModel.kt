package com.ggc.ui_news.screen_news_article

import androidx.lifecycle.viewModelScope
import com.ggc.common.entities.NewsInfo
import com.ggc.common.navigation.NavArgs
import com.ggc.common.utils.SportsNewsViewModel
import com.ggc.common.utils.SportsNewsViewModelSingleLifeEvent
import com.ggc.domain.Interactor
import com.ggc.ui_news.screen_news_article.ScreenNewsArticleViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenNewsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenNewsArticleViewModel(
    private val navArgs: NavArgs.ScreenNewsArticle?,
    private val interactor: Interactor
) : SportsNewsViewModel<ScreenNewsArticleViewModel.Model>(Model()) {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            navArgs?.let {
                val news = interactor.getNewsById(it.newsId)
                updateNews(news)
            }
        }
    }

    fun buttonBackPressed() {
        updateNavigationEvent(Model.NavigationSingleLifeEvent(ScreenNewsList))
    }

    data class Model(
        val news: NewsInfo = NewsInfo(),
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : SportsNewsViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {
                ScreenNewsList
            }
        }
    }

    private fun updateNews(news: NewsInfo) {
        update { it.copy(news = news) }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update { it.copy(navigationEvent = navigationEvent) }
    }
}