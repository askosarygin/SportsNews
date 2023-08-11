package com.ggc.domain

import com.ggc.common.entities.Note
import com.ggc.domain.usecases.AddNoteToDBUseCase
import com.ggc.domain.usecases.DeleteNoteByIdFromDBUseCase
import com.ggc.domain.usecases.GetAllNotesFromDBUseCase
import com.ggc.domain.usecases.GetNoteByIdFromDBUseCase

class InteractorImpl(
    private val addNoteToDBUseCase: AddNoteToDBUseCase,
    private val deleteNoteByIdFromDBUseCase: DeleteNoteByIdFromDBUseCase,
    private val getAllNotesFromDBUseCase: GetAllNotesFromDBUseCase,
    private val getNoteByIdFromDBUseCase: GetNoteByIdFromDBUseCase
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
}