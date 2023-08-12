package com.ggc.domain.usecases

import com.ggc.common.entities.NewsInfo
import com.ggc.domain.Repository

class GetNewsByIdUseCase(
    private val repository: Repository
) {
    suspend fun execute(id: Long): NewsInfo {
        return repository.getNewsById(id)
    }
}