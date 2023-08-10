package com.ggc.ui_match.screen_match

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.R.drawable.test_team_logo
import com.ggc.common.R.font.font_inter_black
import com.ggc.common.R.font.font_inter_regular
import com.ggc.common.R.string.content_description_team_logo
import com.ggc.common.R.string.history_button
import com.ggc.common.entities.MatchInfo
import com.ggc.common.theme.green
import com.ggc.common.theme.green2
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
        ScreenMatch()
    }
}

@Composable
fun ScreenMatch() {
    val items = listOf(
        MatchInfo(
            ImageBitmap.imageResource(id = test_team_logo),
            "Team 1",
            ImageBitmap.imageResource(id = test_team_logo),
            "Team 2",
            "25.06.2022",
            "13:30"
        ),
        MatchInfo(
            ImageBitmap.imageResource(id = test_team_logo),
            "Team 1",
            ImageBitmap.imageResource(id = test_team_logo),
            "Team 2",
            "25.06.2022",
            "13:30"
        ),
        MatchInfo(
            ImageBitmap.imageResource(id = test_team_logo),
            "Team 1",
            ImageBitmap.imageResource(id = test_team_logo),
            "Team 2",
            "25.06.2022",
            "13:30"
        ),
        MatchInfo(
            ImageBitmap.imageResource(id = test_team_logo),
            "Team 1",
            ImageBitmap.imageResource(id = test_team_logo),
            "Team 2",
            "25.06.2022",
            "13:30"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = items) { match ->
            MatchCard(
                teamOneLogo = match.teamOneLogo,
                teamOneName = match.teamOneName,
                teamOneHistoryOnClick = { /*TODO*/ },
                teamTwoLogo = match.teamTwoLogo,
                teamTwoName = match.teamTwoName,
                teamTwoHistoryOnClick = { /*TODO*/ },
                date = match.date,
                time = match.time
            )
        }
    }
}

@Composable
private fun MatchCard(
    teamOneLogo: ImageBitmap,
    teamOneName: String,
    teamOneHistoryOnClick: () -> Unit,
    teamTwoLogo: ImageBitmap,
    teamTwoName: String,
    teamTwoHistoryOnClick: () -> Unit,
    date: String,
    time: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max)
            .background(color = white),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeamInfo(
            teamLogo = teamOneLogo,
            teamName = teamOneName,
            teamHistoryOnClick = teamOneHistoryOnClick
        )

        Column(
            modifier = Modifier.fillMaxHeight().padding(top = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppText(text = date, fontSize = 15.sp, color = green, font = font_inter_regular)
            AppText(text = time, fontSize = 15.sp, color = green, font = font_inter_regular)
        }

        TeamInfo(
            teamLogo = teamTwoLogo,
            teamName = teamTwoName,
            teamHistoryOnClick = teamTwoHistoryOnClick
        )
    }
}

@Composable
private fun TeamInfo(
    teamLogo: ImageBitmap,
    teamName: String,
    teamHistoryOnClick: () -> Unit
) {

    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(width = 57.dp, height = 71.dp),
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

        Button(
            onClick = teamHistoryOnClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = white
            ),
            shape = RoundedCornerShape(size = 6.dp),
            border = BorderStroke(width = 2.dp, color = green2)
        ) {
            AppText(
                text = stringResource(id = history_button),
                fontSize = 11.sp,
                color = green,
                font = font_inter_black
            )
        }
    }
}