package com.ggc.ui_match.screen_history

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.R.drawable.test_team_logo
import com.ggc.common.R.font.font_inter_regular
import com.ggc.common.R.font.font_roboto_condensed_bold
import com.ggc.common.R.font.font_roboto_condensed_regular
import com.ggc.common.R.string._1xPR
import com.ggc.common.R.string._1xPercent
import com.ggc.common.R.string._2xPR
import com.ggc.common.R.string._2xPercent
import com.ggc.common.R.string._3xPR
import com.ggc.common.R.string._3xPercent
import com.ggc.common.R.string.all
import com.ggc.common.R.string.amount
import com.ggc.common.R.string.average
import com.ggc.common.R.string.ball_differential
import com.ggc.common.R.string.blockchain
import com.ggc.common.R.string.content_description_team_logo
import com.ggc.common.R.string.defeats
import com.ggc.common.R.string.draws
import com.ggc.common.R.string.fouls
import com.ggc.common.R.string.fouls_of_the_opponent
import com.ggc.common.R.string.goals_scored
import com.ggc.common.R.string.history_header
import com.ggc.common.R.string.intercepts
import com.ggc.common.R.string.losses
import com.ggc.common.R.string.matches_played
import com.ggc.common.R.string.missed_goals
import com.ggc.common.R.string.pickings_attack
import com.ggc.common.R.string.pickings_defence
import com.ggc.common.R.string.score_points
import com.ggc.common.R.string.selections_total
import com.ggc.common.R.string.statistics_header
import com.ggc.common.R.string.transmissions
import com.ggc.common.R.string.utility_factor
import com.ggc.common.R.string.victory
import com.ggc.common.R.string.viewers
import com.ggc.common.entities.TeamHistoryInfo
import com.ggc.common.theme.green
import com.ggc.common.theme.white
import com.ggc.common.ui_elements.AppText
import com.ggc.common.ui_elements.TopBarBackButton

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
        Column {
            TopBarBackButton(
                headerName = stringResource(id = history_header),
                backButtonClicked = {/*todo*/ }
            )

            ScreenHistory()
        }
    }
}

@Composable
fun ScreenHistory() {
    val teamHistoryInfo = TeamHistoryInfo(
        teamLogo = ImageBitmap.imageResource(id = test_team_logo),
        teamName = "Team 1",
        matches = listOf(
            TeamHistoryInfo.Match(
                rivalLogo = ImageBitmap.imageResource(id = test_team_logo),
                rivalName = "Team 2",
                duration = "85:55",
                date = "25.06.2022",
                time = "13:30"
            ),
            TeamHistoryInfo.Match(
                rivalLogo = ImageBitmap.imageResource(id = test_team_logo),
                rivalName = "Team 2",
                duration = "85:55",
                date = "25.06.2022",
                time = "13:30"
            ),
            TeamHistoryInfo.Match(
                rivalLogo = ImageBitmap.imageResource(id = test_team_logo),
                rivalName = "Team 2",
                duration = "85:55",
                date = "25.06.2022",
                time = "13:30"
            )
        ),
        statistics = TeamHistoryInfo.Statistics(
            amount = TeamHistoryInfo.Statistics.Amount(
                victory = "3",
                draws = "0",
                defeats = "1",
                scorePoints = "7",
                goalsScored = "309",
                missedGoals = "268",
                ballDifferential = "41",
                viewers = "1189",
                _2xPR = "92/184",
                _3xPR = "32/86",
                _1xPR = "29/37",
                pickingsAttack = "37",
                pickingsDefense = "108",
                selectionsTotal = "145",
                transmissions = "101",
                intercepts = "44",
                losses = "59",
                blockchain = "14",
                fouls = "61",
                foulsOfTheOpponent = "0",
                utilityFactor = "339"
            ),
            all = TeamHistoryInfo.Statistics.All(
                matchesPlayed = "4",
                _2xPercent = "50%",
                _3xPercent = "37.2%",
                _1xPercent = "78.4%"
            ),
            average = TeamHistoryInfo.Statistics.Average(
                victory = "75%",
                draws = "0%",
                defeats = "25%",
                scorePoints = "88%",
                goalsScored = "77.25",
                missedGoals = "67",
                ballDifferential = "10.25",
                viewers = "1189",
                _2xPR = "23/46",
                _3xPR = "8/22",
                _1xPR = "7/9",
                pickingsAttack = "9.3",
                pickingsDefense = "27",
                selectionsTotal = "36.3",
                transmissions = "25.3",
                intercepts = "11",
                losses = "14.8",
                blockchain = "3.5",
                fouls = "15.3",
                foulsOfTheOpponent = "0",
                utilityFactor = "84.8"
            )
        )
    )
    Column {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            items(items = teamHistoryInfo.matches) { match ->
                TeamMatch(
                    teamLogo = teamHistoryInfo.teamLogo,
                    teamName = teamHistoryInfo.teamName,
                    rivalLogo = match.rivalLogo,
                    rivalName = match.rivalName,
                    duration = match.duration,
                    date = match.date,
                    time = match.time
                )
            }
        }

        StatisticsCard(statistics = teamHistoryInfo.statistics)
    }

}

@Composable
private fun StatisticsCard(
    statistics: TeamHistoryInfo.Statistics
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 51.dp, end = 51.dp, top = 20.dp, bottom = 31.dp)
            .verticalScroll(state = ScrollState(initial = 0)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StatisticsHeader()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 14.dp)
        ) {
            ColumnNameAll()
            ColumnNameAmountAndAverage()
            StatisticsRowOneValue(
                valueName = stringResource(id = matches_played),
                value = statistics.all.matchesPlayed
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = victory),
                valueFirst = statistics.amount.victory,
                valueSecond = statistics.average.victory
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = draws),
                valueFirst = statistics.amount.draws,
                valueSecond = statistics.average.draws
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = defeats),
                valueFirst = statistics.amount.defeats,
                valueSecond = statistics.average.defeats
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = score_points),
                valueFirst = statistics.amount.scorePoints,
                valueSecond = statistics.average.scorePoints
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = goals_scored),
                valueFirst = statistics.amount.goalsScored,
                valueSecond = statistics.average.goalsScored
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = missed_goals),
                valueFirst = statistics.amount.missedGoals,
                valueSecond = statistics.average.missedGoals
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = ball_differential),
                valueFirst = statistics.amount.ballDifferential,
                valueSecond = statistics.average.ballDifferential
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = viewers),
                valueFirst = statistics.amount.viewers,
                valueSecond = statistics.average.viewers
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = _2xPR),
                valueFirst = statistics.amount._2xPR,
                valueSecond = statistics.average._2xPR
            )
            StatisticsRowOneValue(
                valueName = stringResource(id = _2xPercent),
                value = statistics.all._2xPercent
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = _3xPR),
                valueFirst = statistics.amount._3xPR,
                valueSecond = statistics.average._3xPR
            )
            StatisticsRowOneValue(
                valueName = stringResource(id = _3xPercent),
                value = statistics.all._3xPercent
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = _1xPR),
                valueFirst = statistics.amount._1xPR,
                valueSecond = statistics.average._1xPR
            )
            StatisticsRowOneValue(
                valueName = stringResource(id = _1xPercent),
                value = statistics.all._1xPercent
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = pickings_attack),
                valueFirst = statistics.amount.pickingsAttack,
                valueSecond = statistics.average.pickingsAttack
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = pickings_defence),
                valueFirst = statistics.amount.pickingsDefense,
                valueSecond = statistics.average.pickingsDefense
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = selections_total),
                valueFirst = statistics.amount.selectionsTotal,
                valueSecond = statistics.average.selectionsTotal
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = transmissions),
                valueFirst = statistics.amount.transmissions,
                valueSecond = statistics.average.transmissions
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = intercepts),
                valueFirst = statistics.amount.intercepts,
                valueSecond = statistics.average.intercepts
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = losses),
                valueFirst = statistics.amount.losses,
                valueSecond = statistics.average.losses
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = blockchain),
                valueFirst = statistics.amount.blockchain,
                valueSecond = statistics.average.blockchain
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = fouls),
                valueFirst = statistics.amount.fouls,
                valueSecond = statistics.average.fouls
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = fouls_of_the_opponent),
                valueFirst = statistics.amount.foulsOfTheOpponent,
                valueSecond = statistics.average.foulsOfTheOpponent
            )
            StatisticsRowTwoValues(
                valueName = stringResource(id = utility_factor),
                valueFirst = statistics.amount.utilityFactor,
                valueSecond = statistics.average.utilityFactor
            )
        }
    }
}

@Composable
private fun StatisticsHeader() {
    AppText(
        text = stringResource(id = statistics_header),
        fontSize = 14.sp,
        color = green,
        font = font_roboto_condensed_bold
    )
}


@Composable
private fun ColumnNameAmountAndAverage() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.weight(weight = 2f))
        AppText(
            modifier = Modifier.weight(weight = 1f),
            text = stringResource(id = amount),
            fontSize = 12.sp,
            color = green,
            font = font_roboto_condensed_regular,
            textAlign = TextAlign.Center
        )
        AppText(
            modifier = Modifier.weight(weight = 1f),
            text = stringResource(id = average),
            fontSize = 12.sp,
            color = green,
            font = font_roboto_condensed_regular,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ColumnNameAll() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.weight(weight = 1f))
        AppText(
            modifier = Modifier.weight(weight = 1f),
            text = stringResource(id = all),
            fontSize = 12.sp,
            color = green,
            font = font_roboto_condensed_regular,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun StatisticsRowOneValue(
    valueName: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        AppText(
            modifier = Modifier.weight(weight = 1f),
            text = valueName,
            fontSize = 12.sp,
            color = green,
            font = font_roboto_condensed_regular
        )
        AppText(
            modifier = Modifier.weight(weight = 1f),
            text = value,
            fontSize = 12.sp,
            color = green,
            font = font_roboto_condensed_regular,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun StatisticsRowTwoValues(
    valueName: String,
    valueFirst: String,
    valueSecond: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        AppText(
            modifier = Modifier.weight(weight = 2f),
            text = valueName,
            fontSize = 12.sp,
            color = green,
            font = font_roboto_condensed_regular
        )
        AppText(
            modifier = Modifier.weight(weight = 1f),
            text = valueFirst,
            fontSize = 12.sp,
            color = green,
            font = font_roboto_condensed_regular,
            textAlign = TextAlign.Center
        )
        AppText(
            modifier = Modifier.weight(weight = 1f),
            text = valueSecond,
            fontSize = 12.sp,
            color = green,
            font = font_roboto_condensed_regular,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun TeamMatch(
    teamLogo: ImageBitmap?,
    teamName: String,
    rivalLogo: ImageBitmap?,
    rivalName: String,
    duration: String,
    date: String,
    time: String
) {
    teamLogo?.let {
        rivalLogo?.let {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = white),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .height(height = 27.dp)
                            .padding(start = 10.dp, end = 5.dp),
                        contentScale = ContentScale.FillHeight,
                        bitmap = teamLogo,
                        contentDescription = stringResource(id = content_description_team_logo)
                    )

                    AppText(
                        text = teamName,
                        fontSize = 11.sp,
                        color = green,
                        font = font_inter_regular
                    )
                    AppText(
                        modifier = Modifier.padding(horizontal = 3.dp),
                        text = "-",
                        fontSize = 11.sp,
                        color = green,
                        font = font_inter_regular
                    )
                    AppText(
                        text = rivalName,
                        fontSize = 11.sp,
                        color = green,
                        font = font_inter_regular
                    )

                    Image(
                        modifier = Modifier
                            .height(height = 27.dp)
                            .padding(start = 5.dp),
                        contentScale = ContentScale.FillHeight,
                        bitmap = rivalLogo,
                        contentDescription = stringResource(id = content_description_team_logo)
                    )
                }

                AppText(
                    modifier = Modifier.padding(vertical = 6.dp),
                    text = duration,
                    fontSize = 20.sp,
                    color = green,
                    font = font_inter_regular
                )

                Column(
                    modifier = Modifier.padding(end = 9.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppText(
                        text = date,
                        fontSize = 11.sp,
                        color = green,
                        font = font_inter_regular
                    )
                    AppText(
                        text = time,
                        fontSize = 11.sp,
                        color = green,
                        font = font_inter_regular
                    )
                }
            }
        }
    }
}