package com.ggc.data.db.calendar.month_info

import com.ggc.common.entities.MonthInfo
import java.util.Calendar

interface MonthInfoUtil {
    suspend fun getMonthInfo(month: Calendar): MonthInfo
}