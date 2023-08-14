package com.ggc.data.db.calendar.month_info

import com.ggc.common.entities.MonthInfo
import java.util.Calendar

class MonthsInfoUtilImpl : MonthInfoUtil {
    private suspend fun generateDayCellsForMonth(month: Calendar): List<MonthInfo.DayCell> {
        val result = mutableListOf<MonthInfo.DayCell>()
        val dayOfWeekNumber = month.get(Calendar.DAY_OF_WEEK) - 1

        for (i in 0 until dayOfWeekNumber) {
            result.add(MonthInfo.DayCell(id = i))
        }

        val countOfDaysInMonth = month.getActualMaximum(Calendar.DAY_OF_MONTH)

        for (i in dayOfWeekNumber until dayOfWeekNumber + countOfDaysInMonth) {
            result.add(
                MonthInfo.DayCell(
                    id = i,
                    dayInfo = MonthInfo.DayCell.DayInfo((i - dayOfWeekNumber + 1).toString())
                )
            )
        }

        for (i in dayOfWeekNumber + countOfDaysInMonth .. 41) {
            result.add(MonthInfo.DayCell(id = i))
        }

        return result
    }

    override suspend fun getMonthInfo(month: Calendar): MonthInfo {
        return MonthInfo(
            monthDate = month,
            dayCells = generateDayCellsForMonth(month)
        )
//        return MonthInfo(
//            monthDate = Calendar.getInstance().apply {
//                set(2023, 3, 1, 0, 0, 0)
//            },
//            dayCells = listOf(
//                MonthInfo.DayCell(id = 0),
//                MonthInfo.DayCell(id = 1),
//                MonthInfo.DayCell(id = 2),
//                MonthInfo.DayCell(id = 3),
//                MonthInfo.DayCell(id = 4, dayInfo = MonthInfo.DayCell.DayInfo("1")),
//                MonthInfo.DayCell(id = 5, dayInfo = MonthInfo.DayCell.DayInfo("2")),
//                MonthInfo.DayCell(id = 6, dayInfo = MonthInfo.DayCell.DayInfo("3")),
//                MonthInfo.DayCell(id = 7, dayInfo = MonthInfo.DayCell.DayInfo("4")),
//                MonthInfo.DayCell(id = 8, dayInfo = MonthInfo.DayCell.DayInfo("5")),
//                MonthInfo.DayCell(id = 9, dayInfo = MonthInfo.DayCell.DayInfo("6")),
//                MonthInfo.DayCell(id = 10, dayInfo = MonthInfo.DayCell.DayInfo("7")),
//                MonthInfo.DayCell(id = 11, dayInfo = MonthInfo.DayCell.DayInfo("8")),
//                MonthInfo.DayCell(id = 12, dayInfo = MonthInfo.DayCell.DayInfo("9")),
//                MonthInfo.DayCell(id = 13, dayInfo = MonthInfo.DayCell.DayInfo("10")),
//                MonthInfo.DayCell(id = 14, dayInfo = MonthInfo.DayCell.DayInfo("11")),
//                MonthInfo.DayCell(id = 15, dayInfo = MonthInfo.DayCell.DayInfo("12")),
//                MonthInfo.DayCell(id = 16, dayInfo = MonthInfo.DayCell.DayInfo("13")),
//                MonthInfo.DayCell(id = 17, dayInfo = MonthInfo.DayCell.DayInfo("14")),
//                MonthInfo.DayCell(id = 18, dayInfo = MonthInfo.DayCell.DayInfo("15")),
//                MonthInfo.DayCell(id = 19, dayInfo = MonthInfo.DayCell.DayInfo("16")),
//                MonthInfo.DayCell(id = 20, dayInfo = MonthInfo.DayCell.DayInfo("17")),
//                MonthInfo.DayCell(id = 21, dayInfo = MonthInfo.DayCell.DayInfo("18")),
//                MonthInfo.DayCell(id = 22, dayInfo = MonthInfo.DayCell.DayInfo("19")),
//                MonthInfo.DayCell(id = 23, dayInfo = MonthInfo.DayCell.DayInfo("20")),
//                MonthInfo.DayCell(id = 24, dayInfo = MonthInfo.DayCell.DayInfo("21")),
//                MonthInfo.DayCell(id = 25, dayInfo = MonthInfo.DayCell.DayInfo("22")),
//                MonthInfo.DayCell(id = 26, dayInfo = MonthInfo.DayCell.DayInfo("23")),
//                MonthInfo.DayCell(id = 27, dayInfo = MonthInfo.DayCell.DayInfo("24")),
//                MonthInfo.DayCell(id = 28, dayInfo = MonthInfo.DayCell.DayInfo("25")),
//                MonthInfo.DayCell(id = 29, dayInfo = MonthInfo.DayCell.DayInfo("26")),
//                MonthInfo.DayCell(id = 30, dayInfo = MonthInfo.DayCell.DayInfo("27")),
//                MonthInfo.DayCell(id = 31, dayInfo = MonthInfo.DayCell.DayInfo("28")),
//                MonthInfo.DayCell(id = 32, dayInfo = MonthInfo.DayCell.DayInfo("29")),
//                MonthInfo.DayCell(id = 33, dayInfo = MonthInfo.DayCell.DayInfo("30")),
//                MonthInfo.DayCell(id = 34),
//                MonthInfo.DayCell(id = 35),
//                MonthInfo.DayCell(id = 36),
//                MonthInfo.DayCell(id = 37),
//                MonthInfo.DayCell(id = 38),
//                MonthInfo.DayCell(id = 39),
//                MonthInfo.DayCell(id = 40),
//                MonthInfo.DayCell(id = 41)
//            )
//        )
    }
}