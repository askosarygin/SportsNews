package com.ggc.ui_news.screen_news_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ggc.common.R
import com.ggc.common.R.string.content_description_news_image
import com.ggc.common.entities.NewsInfo
import com.ggc.common.navigation.NavArgs
import com.ggc.common.navigation.Routes
import com.ggc.common.theme.green
import com.ggc.common.theme.white
import com.ggc.common.ui_elements.AppText
import com.ggc.ui_news.screen_news_list.ScreenNewsListViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenNewsArticle

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
//        ScreenNewsList()
//    }
//}

@Composable
fun ScreenNewsList(
    navController: NavController,
    viewModel: ScreenNewsListViewModel
) {
    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { navigationInfo ->
        when (navigationInfo.navigateTo) {
            ScreenNewsArticle -> {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    Routes.ScreenNewsArticle,
                    NavArgs.ScreenNewsArticle(navigationInfo.selectedNewsId)
                )
                navController.navigate(Routes.ScreenNewsArticle)
            }
        }
    }

    LazyColumn(
        modifier = Modifier.padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        items(items = model.news) { newsInfo ->
            NewsCard(
                newsInfo = newsInfo,
                newsOnClick = { viewModel.newsClicked(newsInfo.id)}
            )
        }
    }
}

@Composable
private fun NewsCard(
    newsInfo: NewsInfo,
    newsOnClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clickable(onClick = newsOnClick)
    )
    {
        newsInfo.newsImage?.let { newsImage ->
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth,
                bitmap = newsImage,
                contentDescription = stringResource(id = content_description_news_image)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.8f)
                .background(color = white),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp, end = 23.dp, top = 15.dp, bottom = 33.dp),
                verticalArrangement = Arrangement.spacedBy(space = 10.dp)
            ) {
                AppText(
                    text = newsInfo.title,
                    fontSize = 11.sp,
                    color = green,
                    font = R.font.font_inter_semi_bold
                )
                AppText(
                    text = newsInfo.text,
                    fontSize = 10.sp,
                    color = green,
                    font = R.font.font_inter_regular
                )
            }
        }
    }
}