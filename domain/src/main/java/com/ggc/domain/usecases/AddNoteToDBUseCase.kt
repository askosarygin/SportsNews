package com.ggc.domain.usecases

import com.ggc.common.entities.Note
import com.ggc.common.entities.NoteDB
import com.ggc.domain.Repository

class AddNoteToDBUseCase(
    private val repository: Repository
) {
    suspend fun execute(note: Note): Boolean {
        return repository.addNote(
            NoteDB(
                note.id,
                note.title,
                note.text
            )
        )
    }
}