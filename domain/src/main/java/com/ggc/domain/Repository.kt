package com.ggc.domain

import com.ggc.common.entities.MatchInfo
import com.ggc.common.entities.MonthInfo
import com.ggc.common.entities.NewsInfo
import com.ggc.common.entities.NoteDB
import com.ggc.common.entities.TeamHistoryInfo
import java.util.Calendar

interface Repository {
    suspend fun getAllNotes(): List<NoteDB>

    suspend fun addNote(noteDB: NoteDB): Boolean

    suspend fun deleteNoteById(id: Long): Boolean

    suspend fun getNoteById(id: Long): NoteDB

    suspend fun getAllMatches(): List<MatchInfo>

    suspend fun getTeamHistoryInfoById(id: Long): TeamHistoryInfo

    suspend fun getAllNews(): List<NewsInfo>

    suspend fun getNewsById(id: Long): NewsInfo

    suspend fun getMonthInfo(month: Calendar): MonthInfo
}