package com.ggc.domain.usecases

import com.ggc.common.entities.Note
import com.ggc.domain.Repository

class GetNoteByIdFromDBUseCase(
    private val repository: Repository
) {
    suspend fun execute(id: Long): Note {
        val noteDB = repository.getNoteById(id)
        return Note(
            noteDB.id,
            noteDB.title,
            noteDB.text
        )
    }
}