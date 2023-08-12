package com.ggc.data.db.network

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.bumptech.glide.RequestManager
import com.ggc.common.entities.MatchInfo
import com.ggc.common.entities.NewsInfo
import com.ggc.common.entities.TeamHistoryInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Calendar

class NetworkImpl(
    private val loadBitmap: RequestManager
) : Network {
    private var teamsLoaded: Boolean = false
    private lateinit var bostonCeltics: MatchInfo.TeamInfo
    private lateinit var netsBrooklyn: MatchInfo.TeamInfo
    private lateinit var newYorkKnicks: MatchInfo.TeamInfo
    private lateinit var torontoRaptors: MatchInfo.TeamInfo
    private lateinit var philadelphia76ers: MatchInfo.TeamInfo
    private lateinit var detroitPistons: MatchInfo.TeamInfo
    private lateinit var indianaPacers: MatchInfo.TeamInfo
    private lateinit var clevelandCavaliers: MatchInfo.TeamInfo
    private lateinit var milwaukeeBucks: MatchInfo.TeamInfo
    private lateinit var chicagoBulls: MatchInfo.TeamInfo

    private suspend fun loadBitmapFromUrl(url: String): ImageBitmap {
        return withContext(Dispatchers.IO) {
            loadBitmap.asBitmap().load(url).submit().get()
        }.asImageBitmap()
    }

    private suspend fun loadAllTeams() {
        if (!teamsLoaded) {
            bostonCeltics = MatchInfo.TeamInfo(
                teamId = 0L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-boston-celtics.png"),
                teamName = "Boston Celtics"
            )
            netsBrooklyn = MatchInfo.TeamInfo(
                teamId = 1L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-brooklyn-nets.png"),
                teamName = "Nets Brooklyn"
            )
            newYorkKnicks = MatchInfo.TeamInfo(
                teamId = 2L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-new-york-knicks.png"),
                teamName = "New-York Knicks"
            )
            torontoRaptors = MatchInfo.TeamInfo(
                teamId = 3L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-toronto-raptors.png"),
                teamName = "Toronto Raptors"
            )
            philadelphia76ers = MatchInfo.TeamInfo(
                teamId = 4L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-philadelphia-76-ers.png"),
                teamName = "Philadelphia 76ers"
            )
            detroitPistons = MatchInfo.TeamInfo(
                teamId = 5L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-detroit-pistons.png"),
                teamName = "Detroit Pistons"
            )
            indianaPacers = MatchInfo.TeamInfo(
                teamId = 6L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-indiana-pacers.png"),
                teamName = "Indiana Pacers"
            )
            clevelandCavaliers = MatchInfo.TeamInfo(
                teamId = 7L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-cleveland-cavaliers.png"),
                teamName = "Cleveland Cavaliers"
            )
            milwaukeeBucks = MatchInfo.TeamInfo(
                teamId = 8L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-milwaukee-bucks.png"),
                teamName = "Milwaukee Bucks"
            )
            chicagoBulls = MatchInfo.TeamInfo(
                teamId = 9L,
                teamLogo = loadBitmapFromUrl("https://фк-лого.рф/wp-content/uploads/nba-chicago-bulls.png"),
                teamName = "Chicago Bulls"
            )
            teamsLoaded = true
        }
    }

    override suspend fun getAllMatches(): List<MatchInfo> {
        loadAllTeams()


        return listOf(
            MatchInfo(
                id = 0L,
                matchDate = Calendar.getInstance().apply {
                    set(2023, 7, 10, 15, 30, 0)
                },
                teamOne = bostonCeltics,
                teamTwo = netsBrooklyn
            ),
            MatchInfo(
                id = 0L,
                matchDate = Calendar.getInstance().apply {
                    set(2023, 6, 15, 15, 0, 0)
                },
                teamOne = newYorkKnicks,
                teamTwo = torontoRaptors
            ),
            MatchInfo(
                id = 0L,
                matchDate = Calendar.getInstance().apply {
                    set(2023, 5, 10, 15, 30, 0)
                },
                teamOne = philadelphia76ers,
                teamTwo = detroitPistons
            ),
            MatchInfo(
                id = 0L,
                matchDate = Calendar.getInstance().apply {
                    set(2023, 4, 11, 14, 30, 0)
                },
                teamOne = indianaPacers,
                teamTwo = clevelandCavaliers
            ),
            MatchInfo(
                id = 0L,
                matchDate = Calendar.getInstance().apply {
                    set(2023, 3, 16, 14, 0, 0)
                },
                teamOne = milwaukeeBucks,
                teamTwo = chicagoBulls
            )
        )
    }

    override suspend fun getTeamHistoryInfoById(id: Long): TeamHistoryInfo {
        loadAllTeams()

        val teamsHistory = listOf(
            TeamHistoryInfo(
                teamId = bostonCeltics.teamId,
                teamLogo = bostonCeltics.teamLogo,
                teamName = bostonCeltics.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = netsBrooklyn.teamLogo,
                        rivalName = netsBrooklyn.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = newYorkKnicks.teamLogo,
                        rivalName = newYorkKnicks.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = philadelphia76ers.teamLogo,
                        rivalName = philadelphia76ers.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = netsBrooklyn.teamId,
                teamLogo = netsBrooklyn.teamLogo,
                teamName = netsBrooklyn.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = bostonCeltics.teamLogo,
                        rivalName = bostonCeltics.teamName,
                        duration = "81:50",
                        date = "13.02.2023",
                        time = "15:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = chicagoBulls.teamLogo,
                        rivalName = chicagoBulls.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "14:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.03.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = clevelandCavaliers.teamLogo,
                        rivalName = clevelandCavaliers.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = newYorkKnicks.teamId,
                teamLogo = newYorkKnicks.teamLogo,
                teamName = newYorkKnicks.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = netsBrooklyn.teamLogo,
                        rivalName = netsBrooklyn.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = detroitPistons.teamLogo,
                        rivalName = detroitPistons.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = milwaukeeBucks.teamLogo,
                        rivalName = milwaukeeBucks.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = torontoRaptors.teamId,
                teamLogo = torontoRaptors.teamLogo,
                teamName = torontoRaptors.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = netsBrooklyn.teamLogo,
                        rivalName = netsBrooklyn.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = newYorkKnicks.teamLogo,
                        rivalName = newYorkKnicks.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = detroitPistons.teamLogo,
                        rivalName = detroitPistons.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = philadelphia76ers.teamLogo,
                        rivalName = philadelphia76ers.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = philadelphia76ers.teamId,
                teamLogo = philadelphia76ers.teamLogo,
                teamName = philadelphia76ers.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = netsBrooklyn.teamLogo,
                        rivalName = netsBrooklyn.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = philadelphia76ers.teamLogo,
                        rivalName = philadelphia76ers.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = clevelandCavaliers.teamLogo,
                        rivalName = clevelandCavaliers.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = detroitPistons.teamId,
                teamLogo = detroitPistons.teamLogo,
                teamName = detroitPistons.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = netsBrooklyn.teamLogo,
                        rivalName = netsBrooklyn.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = newYorkKnicks.teamLogo,
                        rivalName = newYorkKnicks.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = philadelphia76ers.teamLogo,
                        rivalName = philadelphia76ers.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = indianaPacers.teamId,
                teamLogo = indianaPacers.teamLogo,
                teamName = indianaPacers.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = milwaukeeBucks.teamLogo,
                        rivalName = milwaukeeBucks.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = detroitPistons.teamLogo,
                        rivalName = detroitPistons.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = philadelphia76ers.teamLogo,
                        rivalName = philadelphia76ers.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = clevelandCavaliers.teamId,
                teamLogo = clevelandCavaliers.teamLogo,
                teamName = clevelandCavaliers.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = indianaPacers.teamLogo,
                        rivalName = indianaPacers.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = newYorkKnicks.teamLogo,
                        rivalName = newYorkKnicks.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = philadelphia76ers.teamLogo,
                        rivalName = philadelphia76ers.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = milwaukeeBucks.teamId,
                teamLogo = milwaukeeBucks.teamLogo,
                teamName = milwaukeeBucks.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = detroitPistons.teamLogo,
                        rivalName = detroitPistons.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = clevelandCavaliers.teamLogo,
                        rivalName = clevelandCavaliers.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = philadelphia76ers.teamLogo,
                        rivalName = philadelphia76ers.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
            ),


            TeamHistoryInfo(
                teamId = chicagoBulls.teamId,
                teamLogo = chicagoBulls.teamLogo,
                teamName = chicagoBulls.teamName,
                matches = listOf(
                    TeamHistoryInfo.Match(
                        rivalLogo = indianaPacers.teamLogo,
                        rivalName = indianaPacers.teamName,
                        duration = "85:50",
                        date = "10.02.2023",
                        time = "13:30"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = milwaukeeBucks.teamLogo,
                        rivalName = milwaukeeBucks.teamName,
                        duration = "82:50",
                        date = "11.03.2023",
                        time = "13:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = torontoRaptors.teamLogo,
                        rivalName = torontoRaptors.teamName,
                        duration = "85:10",
                        date = "07.02.2023",
                        time = "11:00"
                    ),
                    TeamHistoryInfo.Match(
                        rivalLogo = detroitPistons.teamLogo,
                        rivalName = detroitPistons.teamName,
                        duration = "87:50",
                        date = "17.01.2023",
                        time = "14:30"
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
        )

        return teamsHistory.find {
            it.teamId == id
        } ?: TeamHistoryInfo(
            teamId = bostonCeltics.teamId,
            teamLogo = bostonCeltics.teamLogo,
            teamName = bostonCeltics.teamName,
            matches = listOf(
                TeamHistoryInfo.Match(
                    rivalLogo = netsBrooklyn.teamLogo,
                    rivalName = netsBrooklyn.teamName,
                    duration = "85:50",
                    date = "10.02.2023",
                    time = "13:30"
                ),
                TeamHistoryInfo.Match(
                    rivalLogo = newYorkKnicks.teamLogo,
                    rivalName = newYorkKnicks.teamName,
                    duration = "82:50",
                    date = "11.03.2023",
                    time = "13:00"
                ),
                TeamHistoryInfo.Match(
                    rivalLogo = torontoRaptors.teamLogo,
                    rivalName = torontoRaptors.teamName,
                    duration = "85:10",
                    date = "07.02.2023",
                    time = "11:00"
                ),
                TeamHistoryInfo.Match(
                    rivalLogo = philadelphia76ers.teamLogo,
                    rivalName = philadelphia76ers.teamName,
                    duration = "87:50",
                    date = "17.01.2023",
                    time = "14:30"
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
    }

    override suspend fun getAllNews(): List<NewsInfo> {
        return listOf(
            NewsInfo(
                id = 0L,
                newsImage = loadBitmapFromUrl("https://static01.nyt.com/images/2023/08/02/multimedia/02nba-onpro-donations1-hfkz/02nba-onpro-donations1-hfkz-superJumbo.jpg"),
                title = "The N.B.A. and Its Owners Fight for Change. But Not Necessarily the Same Change",
                text = "In June 2022, on the same day the Supreme Court overturned Roe v. Wade, Adam Silver, the N.B.A. commissioner, released a statement jointly with the W.N.B.A.’s commissioner, Cathy Engelbert.\n" +
                        "\n" +
                        "Silver and Engelbert said the leagues believed “that women should be able to make their own decisions concerning their health and future, and we believe that freedom should be protected.”\n" +
                        "\n" +
                        "Less than one year later, one of the N.B.A.’s teams, the Orlando Magic — as an organization — wrote a \$50,000 check to Never Back Down, a super PAC promoting Gov. Ron DeSantis of Florida, financial disclosures revealed this week. The Magic are owned by the DeVos family, well-known conservatives. Betsy DeVos, the daughter-in-law of the former Magic chairman Richard DeVos, who died in 2018, was former president Donald J. Trump’s education secretary.\n" +
                        "\n" +
                        "The check was written on May 19, according to a team spokesman. That was weeks after DeSantis signed one of the most restrictive abortion laws in the country, prohibiting the termination of pregnancies after six weeks, but days before he had officially declared he would run for the Republican presidential nomination.\n" +
                        "\n" +
                        "The donation “was given as a Florida business in support of a Florida governor for the continued prosperity of Central Florida,” the team said in a statement.\n" +
                        "\n" +
                        "The Magic’s donation to DeSantis, who is in his second term as governor, was not the first time an N.B.A. team had put its name on a political donation. In the 1990s, the Phoenix Suns, then owned by Jerry Colangelo, donated tens of thousands to the Republican National Committee. But the Magic’s check appears to be the first direct donation from an N.B.A. team to a group directly allied with a presidential candidate — or one, like DeSantis, who was widely expected to run."
            ),

            NewsInfo(
                id = 1L,
                newsImage = loadBitmapFromUrl("https://static01.nyt.com/images/2023/07/08/multimedia/08nba-summer-wemby-mkcf/08nba-summer-wemby-mkcf-superJumbo.jpg"),
                title = "Victor Wembanyama Gets Introduction to N.B.A. Fame and Game in Las Vegas",
                text = "The walls around Victor Wembanyama, as he sat for a news conference Friday night at the Thomas and Mack Center, were plastered with images of past winners of the Las Vegas Summer League tournament. There were N.B.A. stars who played there in the early days of their careers and a photo of LeBron James from 2018, when he showed up wearing gold shorts that said “Lakers” on the front in his first public appearance after signing with the team.\n" +
                        "\n" +
                        "The summer league debuted the year after James’s rookie season, so its first marquee rookie was Dwight Howard, the top pick in 2004. As Wembanyama spoke with reporters, a picture of a smiling Howard could be seen on a wall to his right.\n" +
                        "\n" +
                        "“The Beatles?” one team executive had joked earlier that night when asked what he would compare to the hysteria around Wembanyama, whom the San Antonio Spurs selected first overall last month. The closest real comparison is to James’s entry into the league in 2003.\n" +
                        "\n" +
                        "Wembanyama had just finished his debut performance in a Spurs jersey, when he scored 9 points with 8 rebounds, 3 assists and 5 blocks. He made 2 of 13 shots and sometimes looked tired.\n" +
                        "\n" +
                        "None of this will matter for his long-term future, nor does it predict what his career will be. But Wembanyama’s first few days in Las Vegas didn’t just introduce him to N.B.A. play, they also introduced him to the absurdity of fame’s glare. He came out of that experience a bit subdued, but still smiling and poised as his journey continued.\n" +
                        "\n" +
                        "Wembanyama only finished his French season three weeks ago, the week before the N.B.A. draft. That he would be selected first overall was a foregone conclusion, but it still brought him to tears when it happened.\n" +
                        "\n" +
                        "The Spurs immediately began molding him. He went to dinner the next day with some of the organization’s legends — Tim Duncan, David Robinson, Sean Elliott and Manu Ginobili — to start learning from them.\n" +
                        "\n" +
                        "They knew his body needed a break, so they had him skip their games in Sacramento last week to save his debut for Las Vegas. He will also skip the World Cup this year, where he would have bolstered the French national team.\n" +
                        "\n" +
                        "And when Wembanyama began playing and practicing with the Spurs’ summer league team, together they focused on learning again.\n" +
                        "\n" +
                        "“There is an eagerness that’s very clear as a coach,” said Matt Nielsen, who is coaching the Spurs’ summer league team. “He’s wanting to do the right thing.”\n" +
                        "\n" +
                        "Friday night’s game featured Wembanyama and the Spurs against the Charlotte Hornets and Brandon Miller, the second overall pick in June’s draft.\n" +
                        "\n" +
                        "The Thomas and Mack Center is a worn-down arena on the campus of the University of Nevada, Las Vegas that once a year dresses itself up as the center of the N.B.A. world.\n" +
                        "\n" +
                        "All 30 N.B.A. teams show up a couple of weeks after the N.B.A. draft for the summer league with rosters that include their most recent draft picks, whom they pray won’t get injured during the exhibition games. Scouts, team owners and executives dot the lower bowls and every so often the league’s biggest stars take a break from casinos, clubs and sponsorship appearances to stop by and sit courtside for a game.\n" +
                        "\n" +
                        "A typical summer league crowd might fill half the lower bowl, and a good crowd packs it and maybe spills into the upper decks. On Friday night, the entire arena was filled to the top with nearly 18,000 spectators hoping to see something spectacular.\n" +
                        "\n" +
                        "Wembanyama had some bright moments, but did not produce the kinds of moments the crowd had waited breathlessly for. He missed a layup and a dunk, in all 11 of the shots he took. He was not the focal point of the Spurs offense for most of the game. Defensively, his natural size and 8-foot wingspan meant he could block jump-shots even when he was late getting to the shot.\n" +
                        "\n" +
                        "At least once, his victim was Miller, who scored 16 points on 5-of-15 shooting with 11 rebounds.\n" +
                        "\n" +
                        "After the game Wembanyama talked about wanting to improve his conditioning, and said he was “exhausted” every time he came out of the game. He needed to better understand the plays called by the point guard, and the team’s defensive system, he said.\n" +
                        "\n" +
                        "“I didn’t really know what I was doing on the court tonight, but I’m trying to learn for the next games,” Wembanyama said. “The important thing is to be ready for the season.”\n" +
                        "\n" +
                        "It was a levelheaded response from Wembanyama, who seemed less effervescent but still poised.\n" +
                        "\n" +
                        "That didn’t stop observers from drawing conclusions about his future or fans of the pop star Britney Spears from mocking his performance."
            ),
            NewsInfo(
                id = 2L,
                newsImage = loadBitmapFromUrl("https://static01.nyt.com/images/2023/07/07/multimedia/07nba-bridges-contract-zlmh/07nba-bridges-contract-zlmh-superJumbo.jpg"),
                title = "Miles Bridges Will Rejoin Hornets After Felony Domestic Violence Plea Deal",
                text = "Miles Bridges will return to the Charlotte Hornets on a one-year contract next season after he finishes a suspension for pleading no contest to felony domestic violence.\n" +
                        "\n" +
                        "Bridges, 25, had been a restricted free agent for the Hornets since June 2022, when he had been expected to negotiate for a \$173 million maximum deal over five years. But on June 29, 2022, he was arrested in Los Angeles, accused of beating the mother of his two children in front of the children. In November, he pleaded no contest to one count of felony domestic violence as part of a plea deal that included three years of probation but no jail time.\n" +
                        "\n" +
                        "“I sincerely apologize for the pain, embarrassment and disappointment that last year’s incident caused so many people,” Bridges said in a statement through the team on Friday, adding that he was “grateful” to have a second chance to play. He had been with the Hornets since they acquired him in a draft-day deal in 2018. His new one-year contract is for \$7.9 million, according to ESPN.\n" +
                        "\n" +
                        "Bridges will have to sit out for the first 10 games next season. The N.B.A. suspended him for 30 games in April, but gave him credit for 20 because he did not play last season. N.B.A. Commissioner Adam Silver later told a group of sports editors that Bridges and the league had a “mutual agreement” that he would not play during the 2022-23 season, though he said the agreement did not constitute a suspension. However, in February Bridges had told The Associated Press that he might return in March.\n" +
                        "\n" +
                        "As part of his plea deal, Bridges was required to undergo a year of domestic violence counseling, complete 100 hours of community service and go to parenting classes. The victim was also granted a 10-year restraining order. Bridges initially faced several felony charges of domestic violence and child abuse.\n" +
                        "\n" +
                        "In the team’s statement on Friday, Hornets General Manager Mitch Kupchak said Bridges’s “commitment to counseling and community service” had factored into Charlotte’s decision to bring him back.\n" +
                        "\n" +
                        "“Throughout this process, we have taken a measured and serious approach,” Kupchak said. He added of Bridges, “He has shown remorse, indicated that he has learned from this situation and expressed that it will not happen again.”\n" +
                        "\n" +
                        "Bridges said that he had been in therapy and that he understood why people had questioned whether he deserved a second chance. He vowed to earn back everyone’s trust and confidence.\n" +
                        "\n" +
                        "Without Bridges last season, the Hornets were the second-worst team in the Eastern Conference. Charlotte’s best player, guard LaMelo Ball, also missed most of the season with injuries. The poor showing positioned the Hornets for a high draft pick, which they used on Alabama’s Brandon Miller at No. 2 overall.\n" +
                        "\n" +
                        "Editors’ Picks\n" +
                        "\n" +
                        "26 Easy Summer Recipes to Make You Feel Better About (Almost) Everything\n" +
                        "\n" +
                        "White Sharks May Have ‘Buddies,’ Researchers Say\n" +
                        "\n" +
                        "I’ve Hidden My Trust Fund for 15 Years. Do I Finally Tell My Spouse?\n" +
                        "Michael Jordan, the former Chicago Bulls great who had owned the Hornets since 2010, announced last month that he would sell his majority stake in the team but stay on as a minority investor."
            ),
            NewsInfo(
                id = 3L,
                newsImage = loadBitmapFromUrl("https://static01.nyt.com/images/2023/06/22/multimedia/22nba-trade-paul-jump-pbvl/22nba-trade-paul-jump-pbvl-superJumbo.jpg"),
                title = "Chris Paul Headed to Golden State in Trade From Wizards",
                text = "The Washington Wizards plan to trade Chris Paul to Golden State for guard Jordan Poole after reaching an agreement to acquire Paul from the Phoenix Suns earlier this week, according to a person familiar with the deals who was not authorized to discuss them publicly.\n" +
                        "\n" +
                        "The plan, which was first reported by ESPN on Thursday just hours before the N.B.A. draft, continues a chaotic off-season for Paul, a 12-time All-Star guard who has spent the past three seasons in Phoenix. Paul, 38, said he was caught off guard on Sunday when he learned that the Suns planned to trade him. The Wizards’ deal with the Suns is expected to send Bradley Beal, a three-time All-Star guard, to Phoenix, according to the person.\n" +
                        "\n" +
                        "“Seriously, it is part of the business, and what you realize is that no one owes you anything,” Paul said of the Suns trading him, in an interview with The New York Times on Monday. “No matter how you are with them or what you do, you realize that in this business, nobody owes you anything, as it should be.”\n" +
                        "In Golden State, Paul would team up with the sharpshooting guards Stephen Curry and Klay Thompson, whom he has faced in the playoffs three times, most memorably in the 2018 Western Conference finals with the Houston Rockets. Golden State beat Houston in seven games that year, with Paul missing the final two games due to injury, then swept Cleveland in the N.B.A. finals. Paul hasn’t won a title, but he helped lead the Suns to the finals in 2021.\n" +
                        "\n" +
                        "In recent years, Paul has scored less and missed time with injuries. In the 2022-23 season, he averaged a career-low 13.9 points per game and missed the Suns’ final four playoff games. But teaming up with Curry, one of the best point guards in N.B.A. history, may provide his best chance to win an elusive championship.\n" +
                        "\n" +
                        "The move is risky for Golden State. Curry, 35, will have in Paul another historically talented guard to help get him easy shots, if Paul can approximate his All-Star form. But if Paul continues to decline, Curry will have to shoulder more of the offensive burden. Paul likely will also have to get used to not being his team’s primary ballhandler.\n" +
                        "\n" +
                        "For Golden State, the trade is a rapid about-face on the 24-year-old Poole, whom the team once viewed as a promising bridge out of the Curry era. So much so that in October, Golden State rewarded Poole with a four-year contract extension worth up to \$140 million.\n" +
                        "\n" +
                        "Poole, who just finished his fourth season, helped Golden State win a championship in 2022. While he has shown potential as an elite scorer, he had a penchant for erratic play and sloppy turnovers. His season got off to a rocky start: During a preseason practice, Golden State forward Draymond Green punched Poole in the face, video of which was leaked to TMZ, causing a headache for a franchise known for stability. The friction between Green and Poole lingered over the season."

            )
        )
    }

    override suspend fun getNewsById(id: Long): NewsInfo {
        val allNews = getAllNews()
        return allNews.find {
            it.id == id
        }?: NewsInfo(
            id = 0L,
            newsImage = loadBitmapFromUrl("https://static01.nyt.com/images/2023/08/02/multimedia/02nba-onpro-donations1-hfkz/02nba-onpro-donations1-hfkz-superJumbo.jpg"),
            title = "The N.B.A. and Its Owners Fight for Change. But Not Necessarily the Same Change",
            text = "In June 2022, on the same day the Supreme Court overturned Roe v. Wade, Adam Silver, the N.B.A. commissioner, released a statement jointly with the W.N.B.A.’s commissioner, Cathy Engelbert.\n" +
                    "\n" +
                    "Silver and Engelbert said the leagues believed “that women should be able to make their own decisions concerning their health and future, and we believe that freedom should be protected.”\n" +
                    "\n" +
                    "Less than one year later, one of the N.B.A.’s teams, the Orlando Magic — as an organization — wrote a \$50,000 check to Never Back Down, a super PAC promoting Gov. Ron DeSantis of Florida, financial disclosures revealed this week. The Magic are owned by the DeVos family, well-known conservatives. Betsy DeVos, the daughter-in-law of the former Magic chairman Richard DeVos, who died in 2018, was former president Donald J. Trump’s education secretary.\n" +
                    "\n" +
                    "The check was written on May 19, according to a team spokesman. That was weeks after DeSantis signed one of the most restrictive abortion laws in the country, prohibiting the termination of pregnancies after six weeks, but days before he had officially declared he would run for the Republican presidential nomination.\n" +
                    "\n" +
                    "The donation “was given as a Florida business in support of a Florida governor for the continued prosperity of Central Florida,” the team said in a statement.\n" +
                    "\n" +
                    "The Magic’s donation to DeSantis, who is in his second term as governor, was not the first time an N.B.A. team had put its name on a political donation. In the 1990s, the Phoenix Suns, then owned by Jerry Colangelo, donated tens of thousands to the Republican National Committee. But the Magic’s check appears to be the first direct donation from an N.B.A. team to a group directly allied with a presidential candidate — or one, like DeSantis, who was widely expected to run."
        )
    }
}