package com.ggc.domain.usecases

import com.ggc.common.entities.MonthInfo
import com.ggc.domain.Repository
import java.util.Calendar

class GetMonthInfoUseCase(
    private val repository: Repository
) {
    suspend fun execute(month: Calendar): MonthInfo {
        return repository.getMonthInfo(month)
    }
}