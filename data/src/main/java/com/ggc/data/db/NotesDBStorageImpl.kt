package com.ggc.data.db

import com.ggc.common.entities.NoteDB

class NotesDBStorageImpl(
    private val notesDB: NotesDAO
): NotesDBStorage {
    override suspend fun addNote(noteDB: NoteDB): Boolean {
        notesDB.add(
            NoteDatabaseClass(
                noteDB.id,
                noteDB.title,
                noteDB.text
            )
        )
        return true
    }

    override suspend fun deleteNoteById(id: Long): Boolean {
        notesDB.deleteById(id)
        return true
    }

    override suspend fun getNoteById(id: Long): NoteDB {
        val noteFromDB = notesDB.getById(id)
        return NoteDB(
            noteFromDB.id,
            noteFromDB.title,
            noteFromDB.text
        )
    }

    override suspend fun getAllNotes(): List<NoteDB> {
        return notesDB.getAll().map {
            NoteDB(
                it.id,
                it.title,
                it.text
            )
        }
    }

}