package com.ggc.sportsnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.navigation.Routes
import com.ggc.ui_calendar.screen_calendar.ScreenCalendar
import com.ggc.ui_interactive.screen_interactive.ScreenInteractive1
import com.ggc.ui_interactive.screen_interactive.ScreenInteractiveViewModel
import com.ggc.ui_match.screen_history.ScreenHistory
import com.ggc.ui_match.screen_match.ScreenMatch
import com.ggc.ui_news.screen_news_article.ScreenNewsArticle
import com.ggc.ui_news.screen_news_list.ScreenNewsList
import com.ggc.ui_notes.screen_create_note.ScreenCreateNote
import com.ggc.ui_notes.screen_edit_note.ScreenEditNote
import com.ggc.ui_notes.screen_notes.ScreenNotes

class MainActivity : ComponentActivity() {
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
                        ScreenMatch()
                    }
                    composable(route = Routes.ScreenHistory) {
                        ScreenHistory()
                    }
                    composable(route = Routes.ScreenNewsList) {
                        ScreenNewsList()
                    }
                    composable(route = Routes.ScreenNewsArticle) {
                        ScreenNewsArticle()
                    }
                    composable(route = Routes.ScreenNotes) {
                        ScreenNotes()
                    }
                    composable(route = Routes.ScreenCreateNote) {
                        ScreenCreateNote()
                    }
                    composable(route = Routes.ScreenEditNote) {
                        ScreenEditNote()
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