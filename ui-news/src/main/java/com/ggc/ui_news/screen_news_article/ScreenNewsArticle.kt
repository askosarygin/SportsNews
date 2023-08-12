package com.ggc.ui_news.screen_news_article

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ggc.common.R.string.content_description_news_image
import com.ggc.common.R.string.top_bar_navigation_news
import com.ggc.common.navigation.Routes
import com.ggc.common.theme.green
import com.ggc.common.ui_elements.AppText
import com.ggc.common.ui_elements.TopBarBackButton
import com.ggc.ui_news.screen_news_article.ScreenNewsArticleViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenNewsList

//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    AppTopBarNavigation(
//        matchOnClick = { /*TODO*/ },
//        newsOnClick = { /*TODO*/ },
//        notesOnClick = { /*TODO*/ },
//        calendarOnClick = { /*TODO*/ },
//        interactiveOnClick = { /*TODO*/ }
//    ) {
//        Column {
//            TopBarBackButton(
//                headerName = stringResource(id = top_bar_navigation_news),
//                backButtonClicked = {/*TODO*/ }
//            )
//
//            ScreenNewsArticle()
//        }
//    }
//}

@Composable
fun ScreenNewsArticle(
    navController: NavController,
    viewModel: ScreenNewsArticleViewModel
) {
    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { route ->
        when (route) {
            ScreenNewsList -> navController.navigate(Routes.ScreenNewsList)
        }
    }
    Column {
        TopBarBackButton(
            headerName = stringResource(id = top_bar_navigation_news),
            backButtonClicked = { viewModel.buttonBackPressed() }
        )

        model.news.newsImage?.let { newsImage ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 5.dp)
                    .verticalScroll(state = ScrollState(initial = 0)),
                verticalArrangement = Arrangement.spacedBy(space = 13.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    bitmap = newsImage,
                    contentDescription = stringResource(id = content_description_news_image)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp, end = 23.dp, bottom = 33.dp),
                    verticalArrangement = Arrangement.spacedBy(space = 10.dp)
                ) {
                    AppText(
                        text = model.news.title,
                        fontSize = 11.sp,
                        color = green,
                        font = com.ggc.common.R.font.font_inter_semi_bold
                    )
                    AppText(
                        text = model.news.text,
                        fontSize = 10.sp,
                        color = green,
                        font = com.ggc.common.R.font.font_inter_regular
                    )
                }
            }
        }
    }
}