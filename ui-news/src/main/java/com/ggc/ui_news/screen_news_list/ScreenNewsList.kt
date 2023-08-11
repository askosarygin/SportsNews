package com.ggc.ui_news.screen_news_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.R
import com.ggc.common.R.drawable.test_news_image
import com.ggc.common.R.string.content_description_news_image
import com.ggc.common.entities.NewsInfo
import com.ggc.common.theme.green
import com.ggc.common.theme.white
import com.ggc.common.ui_elements.AppText

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTopBarNavigation(
        matchOnClick = { /*TODO*/ },
        newsOnClick = { /*TODO*/ },
        notesOnClick = { /*TODO*/ },
        calendarOnClick = { /*TODO*/ },
        interactiveOnClick = { /*TODO*/ }
    ) {
        ScreenNewsList()
    }
}

@Composable
fun ScreenNewsList() {
    val news = listOf(
        NewsInfo(
            id = 0L,
            newsImage = ImageBitmap.imageResource(id = test_news_image),
            "Yannis Adetokunbo: Stephen Curry is the best basketball player in the world",
            "Milwaukee Bucks forward Yannis Adetokunbo spoke out about the best basketball player in the world in his opinion.\n" +
                    "\"I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions.\n" +
                    "A couple of years ago, when we did it, I was lying in bed and quietly muttering, \"Maybe I'm the best in the world.\" But now I'm not. The best is a winner. Stephen Curry is the best in the world right now,\" the NBA press office quotes Adetokunbo as saying.\n" +
                    "Curry won his fourth NBA championship in his career with Golden State Warriors last season and was named MVP of the Finals for the first time.\n" +
                    "Milwaukee Bucks forward Yannis Adetokunbo spoke out about the best basketball player in the world in his opinion.\n" +
                    "\"I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions.\n" +
                    "A couple of years ago, when we did it, I was lying in bed and quietly muttering, \"Maybe I'm the best in the world.\" But now I'm not. The best is a winner. Stephen Curry is the best in the world right now,\" the NBA press office quotes Adetokunbo as saying."
        ),
        NewsInfo(
            id = 1L,
            newsImage = ImageBitmap.imageResource(id = test_news_image),
            "Yannis Adetokunbo: Stephen Curry is the best basketball player in the world",
            "Milwaukee Bucks forward Yannis Adetokunbo spoke out about the best basketball player in the world in his opinion.\n" +
                    "\"I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions.\n" +
                    "A couple of years ago, when we did it, I was lying in bed and quietly muttering, \"Maybe I'm the best in the world.\" But now I'm not. The best is a winner. Stephen Curry is the best in the world right now,\" the NBA press office quotes Adetokunbo as saying.\n" +
                    "Curry won his fourth NBA championship in his career with Golden State Warriors last season and was named MVP of the Finals for the first time.\n" +
                    "Milwaukee Bucks forward Yannis Adetokunbo spoke out about the best basketball player in the world in his opinion.\n" +
                    "\"I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions.\n" +
                    "A couple of years ago, when we did it, I was lying in bed and quietly muttering, \"Maybe I'm the best in the world.\" But now I'm not. The best is a winner. Stephen Curry is the best in the world right now,\" the NBA press office quotes Adetokunbo as saying."
        ),
        NewsInfo(
            id = 2L,
            newsImage = ImageBitmap.imageResource(id = test_news_image),
            "Yannis Adetokunbo: Stephen Curry is the best basketball player in the world",
            "Milwaukee Bucks forward Yannis Adetokunbo spoke out about the best basketball player in the world in his opinion.\n" +
                    "\"I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions.\n" +
                    "A couple of years ago, when we did it, I was lying in bed and quietly muttering, \"Maybe I'm the best in the world.\" But now I'm not. The best is a winner. Stephen Curry is the best in the world right now,\" the NBA press office quotes Adetokunbo as saying.\n" +
                    "Curry won his fourth NBA championship in his career with Golden State Warriors last season and was named MVP of the Finals for the first time.\n" +
                    "Milwaukee Bucks forward Yannis Adetokunbo spoke out about the best basketball player in the world in his opinion.\n" +
                    "\"I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions.\n" +
                    "A couple of years ago, when we did it, I was lying in bed and quietly muttering, \"Maybe I'm the best in the world.\" But now I'm not. The best is a winner. Stephen Curry is the best in the world right now,\" the NBA press office quotes Adetokunbo as saying."
        )
    )
    LazyColumn(
        modifier = Modifier.padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        items(items = news) { newsInfo ->
            NewsCard(newsInfo = newsInfo)
        }
    }
}

@Composable
private fun NewsCard(
    newsInfo: NewsInfo
) {
    Box(
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
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