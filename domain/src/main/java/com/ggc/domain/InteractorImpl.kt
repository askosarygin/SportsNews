package com.ggc.domain

import com.ggc.common.entities.MatchInfo
import com.ggc.common.entities.NewsInfo
import com.ggc.common.entities.Note
import com.ggc.common.entities.TeamHistoryInfo
import com.ggc.domain.usecases.AddNoteToDBUseCase
import com.ggc.domain.usecases.DeleteNoteByIdFromDBUseCase
import com.ggc.domain.usecases.GetAllMatchesUseCase
import com.ggc.domain.usecases.GetAllNewsUseCase
import com.ggc.domain.usecases.GetAllNotesFromDBUseCase
import com.ggc.domain.usecases.GetNewsByIdUseCase
import com.ggc.domain.usecases.GetNoteByIdFromDBUseCase
import com.ggc.domain.usecases.GetTeamHistoryInfoByIdUseCase

class InteractorImpl(
    private val addNoteToDBUseCase: AddNoteToDBUseCase,
    private val deleteNoteByIdFromDBUseCase: DeleteNoteByIdFromDBUseCase,
    private val getAllNotesFromDBUseCase: GetAllNotesFromDBUseCase,
    private val getNoteByIdFromDBUseCase: GetNoteByIdFromDBUseCase,
    private val getAllMatchesUseCase: GetAllMatchesUseCase,
    private val getAllNewsUseCase: GetAllNewsUseCase,
    private val getNewsByIdUseCase: GetNewsByIdUseCase,
    private val getTeamHistoryInfoByIdUseCase: GetTeamHistoryInfoByIdUseCase
): Interactor {
    override suspend fun getAllNotes(): List<Note> {
        return getAllNotesFromDBUseCase.execute()
    }

    override suspend fun addNote(note: Note): Boolean {
        return addNoteToDBUseCase.execute(note)
    }

    override suspend fun deleteNoteById(id: Long): Boolean {
        return deleteNoteByIdFromDBUseCase.execute(id)
    }

    override suspend fun getNoteById(id: Long): Note {
        return getNoteByIdFromDBUseCase.execute(id)
    }

    override suspend fun getAllMatches(): List<MatchInfo> {
        return getAllMatchesUseCase.execute()
    }

    override suspend fun getTeamHistoryInfoById(id: Long): TeamHistoryInfo {
        return getTeamHistoryInfoByIdUseCase.execute(id)
    }

    override suspend fun getAllNews(): List<NewsInfo> {
        return getAllNewsUseCase.execute()
    }

    override suspend fun getNewsById(id: Long): NewsInfo {
        return getNewsByIdUseCase.execute(id)
    }
}