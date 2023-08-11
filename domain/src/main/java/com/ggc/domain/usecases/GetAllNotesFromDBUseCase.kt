package com.ggc.domain.usecases

import com.ggc.common.entities.Note
import com.ggc.domain.Repository

class GetAllNotesFromDBUseCase(
    private val repository: Repository
) {
    suspend fun execute(): List<Note> {
        return repository.getAllNotes().map {
            Note(
                it.id,
                it.title,
                it.text
            )
        }
    }
}