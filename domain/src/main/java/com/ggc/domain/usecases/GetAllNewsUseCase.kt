package com.ggc.domain.usecases

import com.ggc.common.entities.NewsInfo
import com.ggc.domain.Repository

class GetAllNewsUseCase(
    private val repository: Repository
) {
    suspend fun execute(): List<NewsInfo> {
        return repository.getAllNews()
    }
}