package com.ggc.data.db.network

import com.ggc.common.entities.MatchInfo
import com.ggc.common.entities.NewsInfo
import com.ggc.common.entities.TeamHistoryInfo

interface Network {
    suspend fun getAllMatches(): List<MatchInfo>

    suspend fun getTeamHistoryInfoById(id: Long): TeamHistoryInfo

    suspend fun getAllNews(): List<NewsInfo>

    suspend fun getNewsById(id: Long): NewsInfo
}