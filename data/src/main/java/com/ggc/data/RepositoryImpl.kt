package com.ggc.data

import com.ggc.common.entities.NoteDB
import com.ggc.data.appdata.AppData
import com.ggc.data.db.NotesDBStorage
import com.ggc.domain.Repository

class RepositoryImpl(
    private val appData: AppData,
    private val notesDB: NotesDBStorage
): Repository {
    override suspend fun getAllNotes(): List<NoteDB> {
        return notesDB.getAllNotes()
    }

    override suspend fun addNote(noteDB: NoteDB): Boolean {
        return notesDB.addNote(noteDB)
    }

    override suspend fun deleteNoteById(id: Long): Boolean {
        return notesDB.deleteNoteById(id)
    }

    override suspend fun getNoteById(id: Long): NoteDB {
        return notesDB.getNoteById(id)
    }

}