package com.ggc.domain.usecases

import com.ggc.common.entities.TeamHistoryInfo
import com.ggc.domain.Repository

class GetTeamHistoryInfoByIdUseCase(
    private val repository: Repository
) {
    suspend fun execute(id: Long): TeamHistoryInfo {
        return repository.getTeamHistoryInfoById(id)
    }
}