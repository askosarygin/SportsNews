package com.ggc.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.R.drawable.icon_calendar
import com.ggc.common.R.drawable.icon_interactive
import com.ggc.common.R.drawable.icon_match
import com.ggc.common.R.drawable.icon_news
import com.ggc.common.R.drawable.icon_notes
import com.ggc.common.R.font.font_inter_regular
import com.ggc.common.R.string.content_description_calendar
import com.ggc.common.R.string.content_description_interactive
import com.ggc.common.R.string.content_description_match
import com.ggc.common.R.string.content_description_news
import com.ggc.common.R.string.content_description_notes
import com.ggc.common.R.string.top_bar_navigation_calendar
import com.ggc.common.R.string.top_bar_navigation_interactive
import com.ggc.common.R.string.top_bar_navigation_match
import com.ggc.common.R.string.top_bar_navigation_news
import com.ggc.common.R.string.top_bar_navigation_notes
import com.ggc.common.theme.blueDark
import com.ggc.common.theme.grey
import com.ggc.common.theme.white
import com.ggc.common.theme.whiteDark
import com.ggc.common.ui_elements.AppText

//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    AppTopBarNavigation({})
//}

@Composable
fun AppTopBarNavigation(
    matchOnClick: () -> Unit,
    newsOnClick: () -> Unit,
    notesOnClick: () -> Unit,
    calendarOnClick: () -> Unit,
    interactiveOnClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = whiteDark)
    ) {
        TopBar(
            matchOnClick = matchOnClick,
            newsOnClick = newsOnClick,
            notesOnClick = notesOnClick,
            calendarOnClick = calendarOnClick,
            interactiveOnClick = interactiveOnClick
        )

        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}

@Composable
private fun TopBar(
    matchOnClick: () -> Unit,
    newsOnClick: () -> Unit,
    notesOnClick: () -> Unit,
    calendarOnClick: () -> Unit,
    interactiveOnClick: () -> Unit
) {
    var matchActivated by remember { mutableStateOf(true) }
    var newsActivated by remember { mutableStateOf(false) }
    var notesActivated by remember { mutableStateOf(false) }
    var calendarActivated by remember { mutableStateOf(false) }
    var interactiveActivated by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .background(color = blueDark)
            .padding(vertical = 8.5.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier
                .weight(weight = 1f)
                .clickable(onClick = {
                    if (!matchActivated) {
                        matchOnClick()
                        matchActivated = true
                        newsActivated = false
                        notesActivated = false
                        calendarActivated = false
                        interactiveActivated = false
                    }
                }),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                colorFilter = ColorFilter.tint(color = if (matchActivated) white else grey),
                painter = painterResource(id = icon_match),
                contentDescription = stringResource(id = content_description_match)
            )
            AppText(
                modifier = Modifier.padding(top = 5.dp),
                text = stringResource(id = top_bar_navigation_match),
                fontSize = 12.sp,
                color = if (matchActivated) white else grey,
                font = font_inter_regular
            )
        }
        Column(
            modifier = Modifier
                .weight(weight = 1f)
                .clickable(onClick = {
                    if (!newsActivated) {
                        newsOnClick()
                        matchActivated = false
                        newsActivated = true
                        notesActivated = false
                        calendarActivated = false
                        interactiveActivated = false
                    }
                }),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                colorFilter = ColorFilter.tint(color = if (newsActivated) white else grey),
                painter = painterResource(id = icon_news),
                contentDescription = stringResource(id = content_description_news)
            )
            AppText(
                modifier = Modifier.padding(top = 7.4.dp),
                text = stringResource(id = top_bar_navigation_news),
                fontSize = 12.sp,
                color = if (newsActivated) white else grey,
                font = font_inter_regular
            )
        }
        Column(
            modifier = Modifier
                .weight(weight = 1f)
                .clickable(onClick = {
                    if (!notesActivated) {
                        notesOnClick()
                        matchActivated = false
                        newsActivated = false
                        notesActivated = true
                        calendarActivated = false
                        interactiveActivated = false
                    }
                }),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                colorFilter = ColorFilter.tint(color = if (notesActivated) white else grey),
                painter = painterResource(id = icon_notes),
                contentDescription = stringResource(id = content_description_notes)
            )
            AppText(
                modifier = Modifier.padding(top = 5.dp),
                text = stringResource(id = top_bar_navigation_notes),
                fontSize = 12.sp,
                color = if (notesActivated) white else grey,
                font = font_inter_regular
            )
        }
        Column(
            modifier = Modifier
                .weight(weight = 1f)
                .clickable(onClick = {
                    if (!calendarActivated) {
                        calendarOnClick()
                        matchActivated = false
                        newsActivated = false
                        notesActivated = false
                        calendarActivated = true
                        interactiveActivated = false
                    }
                }),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                colorFilter = ColorFilter.tint(color = if (calendarActivated) white else grey),
                painter = painterResource(id = icon_calendar),
                contentDescription = stringResource(id = content_description_calendar)
            )
            AppText(
                modifier = Modifier.padding(top = 5.dp),
                text = stringResource(id = top_bar_navigation_calendar),
                fontSize = 12.sp,
                color = if (calendarActivated) white else grey,
                font = font_inter_regular
            )
        }
        Column(
            modifier = Modifier
                .weight(weight = 1f)
                .clickable(onClick = {
                    if (!interactiveActivated) {
                        interactiveOnClick()
                        matchActivated = false
                        newsActivated = false
                        notesActivated = false
                        calendarActivated = false
                        interactiveActivated = true
                    }
                }),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                colorFilter = ColorFilter.tint(color = if (interactiveActivated) white else grey),
                painter = painterResource(id = icon_interactive),
                contentDescription = stringResource(id = content_description_interactive)
            )
            AppText(
                modifier = Modifier.padding(top = 9.08.dp),
                text = stringResource(id = top_bar_navigation_interactive),
                fontSize = 12.sp,
                color = if (interactiveActivated) white else grey,
                font = font_inter_regular
            )
        }
    }
}