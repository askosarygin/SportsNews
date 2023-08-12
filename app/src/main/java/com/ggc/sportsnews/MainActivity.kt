package com.ggc.sportsnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.navigation.NavArgs
import com.ggc.common.navigation.Routes
import com.ggc.ui_calendar.screen_calendar.ScreenCalendar
import com.ggc.ui_interactive.screen_interactive.ScreenInteractive1
import com.ggc.ui_interactive.screen_interactive.ScreenInteractiveViewModel
import com.ggc.ui_match.screen_history.ScreenHistory
import com.ggc.ui_match.screen_history.ScreenHistoryViewModel
import com.ggc.ui_match.screen_match.ScreenMatch
import com.ggc.ui_match.screen_match.ScreenMatchViewModel
import com.ggc.ui_news.screen_news_article.ScreenNewsArticle
import com.ggc.ui_news.screen_news_article.ScreenNewsArticleViewModel
import com.ggc.ui_news.screen_news_list.ScreenNewsList
import com.ggc.ui_news.screen_news_list.ScreenNewsListViewModel
import com.ggc.ui_notes.screen_create_note.ScreenCreateNote
import com.ggc.ui_notes.screen_create_note.ScreenCreateNoteViewModel
import com.ggc.ui_notes.screen_edit_note.ScreenEditNote
import com.ggc.ui_notes.screen_edit_note.ScreenEditNoteViewModel
import com.ggc.ui_notes.screen_notes.ScreenNotes
import com.ggc.ui_notes.screen_notes.ScreenNotesViewModel

class MainActivity : ComponentActivity() {
    private fun getAppInstance() = application as MainApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AppTopBarNavigation(
                matchOnClick = { navController.navigate(route = Routes.ScreenMatch)},
                newsOnClick = { navController.navigate(route = Routes.ScreenNewsList) },
                notesOnClick = { navController.navigate(route = Routes.ScreenNotes) },
                calendarOnClick = { navController.navigate(route = Routes.ScreenCalendar) },
                interactiveOnClick = { navController.navigate(route = Routes.ScreenInteractive) })
            {
                NavHost(navController = navController, startDestination = Routes.ScreenMatch) {
                    composable(route = Routes.ScreenMatch) {
                        ScreenMatch(
                            navController = navController,
                            viewModel = ScreenMatchViewModel(
                                interactor = getAppInstance().interactor
                            )
                        )
                    }
                    composable(route = Routes.ScreenHistory) {
                        val navArg = navController.previousBackStackEntry?.savedStateHandle?.get<NavArgs.ScreenHistory>(Routes.ScreenHistory)
                        ScreenHistory(
                            navController = navController,
                            viewModel = ScreenHistoryViewModel(
                                navArg = navArg,
                                interactor = getAppInstance().interactor
                            )
                        )
                    }
                    composable(route = Routes.ScreenNewsList) {
                        ScreenNewsList(
                            navController = navController,
                            viewModel = ScreenNewsListViewModel(
                                interactor = getAppInstance().interactor
                            )
                        )
                    }
                    composable(route = Routes.ScreenNewsArticle) {
                        val navArg = navController.previousBackStackEntry?.savedStateHandle?.get<NavArgs.ScreenNewsArticle>(Routes.ScreenNewsArticle)
                        ScreenNewsArticle(
                            navController = navController,
                            viewModel = ScreenNewsArticleViewModel(
                                navArgs = navArg,
                                interactor = getAppInstance().interactor
                            )
                        )
                    }
                    composable(route = Routes.ScreenNotes) {
                        ScreenNotes(
                            navController = navController,
                            viewModel = ScreenNotesViewModel(
                                interactor = getAppInstance().interactor
                            )
                        )
                    }
                    composable(route = Routes.ScreenCreateNote) {
                        ScreenCreateNote(
                            navController = navController,
                            viewModel = ScreenCreateNoteViewModel(
                                interactor = getAppInstance().interactor
                            )
                        )
                    }
                    composable(route = Routes.ScreenEditNote) {
                        val navArg = navController.previousBackStackEntry?.savedStateHandle?.get<NavArgs.ScreenEditNote>(Routes.ScreenEditNote)
                        ScreenEditNote(
                            navController = navController,
                            viewModel = ScreenEditNoteViewModel(
                                navArg = navArg,
                                interactor = getAppInstance().interactor
                            )
                        )
                    }
                    composable(route = Routes.ScreenCalendar) {
                        ScreenCalendar()
                    }
                    composable(route = Routes.ScreenInteractive) {
                        ScreenInteractive1(
                            viewModel = ScreenInteractiveViewModel()
                        )
                    }
                }
            }
        }
    }
}