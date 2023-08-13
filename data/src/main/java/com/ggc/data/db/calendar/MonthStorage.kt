package com.ggc.data.db.calendar

import com.ggc.common.entities.MonthInfo
import java.util.Calendar

interface MonthStorage {
    suspend fun getMonthInfo(month: Calendar): MonthInfo
}