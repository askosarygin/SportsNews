package com.ggc.domain

import com.ggc.common.entities.MatchInfo
import com.ggc.common.entities.NewsInfo
import com.ggc.common.entities.Note
import com.ggc.common.entities.TeamHistoryInfo

interface Interactor {
    suspend fun getAllNotes(): List<Note>

    suspend fun addNote(note: Note): Boolean

    suspend fun deleteNoteById(id: Long): Boolean

    suspend fun getNoteById(id: Long): Note

    suspend fun getAllMatches(): List<MatchInfo>

    suspend fun getTeamHistoryInfoById(id: Long): TeamHistoryInfo

    suspend fun getAllNews(): List<NewsInfo>

    suspend fun getNewsById(id: Long): NewsInfo
}