package com.ggc.ui_match.screen_match

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ggc.common.R.font.font_inter_black
import com.ggc.common.R.font.font_inter_regular
import com.ggc.common.R.string.content_description_team_logo
import com.ggc.common.R.string.history_button
import com.ggc.common.navigation.NavArgs
import com.ggc.common.navigation.Routes
import com.ggc.common.theme.green
import com.ggc.common.theme.green2
import com.ggc.common.theme.white
import com.ggc.common.ui_elements.AppText
import com.ggc.ui_match.screen_match.ScreenMatchViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenHistory

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
//        ScreenMatch()
//    }
//}

@Composable
fun ScreenMatch(
    navController: NavController,
    viewModel: ScreenMatchViewModel
) {
    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { navigationInfo ->
        when (navigationInfo.navigateTo) {
            ScreenHistory -> {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    Routes.ScreenHistory,
                    NavArgs.ScreenHistory(navigationInfo.selectedTeamId)
                )
                navController.navigate(Routes.ScreenHistory)
            }
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = model.matches) { match ->
            MatchCard(
                teamOneLogo = match.teamOne.teamLogo,
                teamOneName = match.teamOne.teamName,
                teamOneHistoryOnClick = { viewModel.buttonHistoryPressed(match.teamOne.teamId) },
                teamTwoLogo = match.teamTwo.teamLogo,
                teamTwoName = match.teamTwo.teamName,
                teamTwoHistoryOnClick = { viewModel.buttonHistoryPressed(match.teamTwo.teamId) },
                date = match.date,
                time = match.time
            )
        }
    }
}

@Composable
private fun MatchCard(
    teamOneLogo: ImageBitmap?,
    teamOneName: String,
    teamOneHistoryOnClick: () -> Unit,
    teamTwoLogo: ImageBitmap?,
    teamTwoName: String,
    teamTwoHistoryOnClick: () -> Unit,
    date: String,
    time: String
) {
    teamOneLogo?.let {
        teamTwoLogo?.let {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Max)
                    .background(color = white),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TeamInfo(
                    modifier = Modifier.weight(weight = 1f),
                    teamLogo = teamOneLogo,
                    teamName = teamOneName,
                    teamHistoryOnClick = teamOneHistoryOnClick
                )

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 45.dp)
                        .weight(weight = 1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppText(text = date, fontSize = 15.sp, color = green, font = font_inter_regular)
                    AppText(text = time, fontSize = 15.sp, color = green, font = font_inter_regular)
                }

                TeamInfo(
                    modifier = Modifier.weight(weight = 1f),
                    teamLogo = teamTwoLogo,
                    teamName = teamTwoName,
                    teamHistoryOnClick = teamTwoHistoryOnClick
                )
            }
        }
    }
}

@Composable
private fun TeamInfo(
    modifier: Modifier = Modifier,
    teamLogo: ImageBitmap,
    teamName: String,
    teamHistoryOnClick: () -> Unit
) {

    Column(
        modifier = modifier.padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(width = 71.dp, height = 71.dp),
            bitmap = teamLogo,
            contentDescription = stringResource(id = content_description_team_logo)
        )

        AppText(
            modifier = Modifier.padding(vertical = 10.dp),
            text = teamName,
            fontSize = 12.sp,
            color = green,
            font = font_inter_regular
        )

        AppText(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = green2,
                    shape = RoundedCornerShape(size = 6.dp)
                )
                .padding(vertical = 6.dp, horizontal = 12.dp)
                .clickable(onClick = teamHistoryOnClick),
            text = stringResource(id = history_button),
            fontSize = 11.sp,
            color = green,
            font = font_inter_black
        )
    }
}