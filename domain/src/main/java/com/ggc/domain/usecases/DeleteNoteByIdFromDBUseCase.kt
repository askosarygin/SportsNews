package com.ggc.domain.usecases

import com.ggc.domain.Repository

class DeleteNoteByIdFromDBUseCase(
    private val repository: Repository
) {
    suspend fun execute(id: Long): Boolean {
        return repository.deleteNoteById(id)
    }
}