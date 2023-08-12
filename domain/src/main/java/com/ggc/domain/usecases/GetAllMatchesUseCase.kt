package com.ggc.domain.usecases

import com.ggc.common.entities.MatchInfo
import com.ggc.domain.Repository

class GetAllMatchesUseCase(
    private val repository: Repository
) {
    suspend fun execute(): List<MatchInfo> {
        return repository.getAllMatches()
    }
}