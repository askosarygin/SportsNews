package com.ggc.domain

import com.ggc.common.entities.Note

interface Interactor {
    suspend fun getAllNotes(): List<Note>

    suspend fun addNote(note: Note): Boolean

    suspend fun deleteNoteById(id: Long): Boolean

    suspend fun getNoteById(id: Long): Note
}