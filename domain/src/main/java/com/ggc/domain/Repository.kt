package com.ggc.domain

import com.ggc.common.entities.NoteDB

interface Repository {
    suspend fun getAllNotes(): List<NoteDB>

    suspend fun addNote(noteDB: NoteDB): Boolean

    suspend fun deleteNoteById(id: Long): Boolean

    suspend fun getNoteById(id: Long): NoteDB
}