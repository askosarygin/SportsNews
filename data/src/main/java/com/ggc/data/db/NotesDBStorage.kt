package com.ggc.data.db

import com.ggc.common.entities.NoteDB


interface NotesDBStorage {
    suspend fun addNote(noteDB: NoteDB): Boolean

    suspend fun deleteNoteById(id: Long): Boolean

    suspend fun getNoteById(id: Long): NoteDB

    suspend fun getAllNotes(): List<NoteDB>
}