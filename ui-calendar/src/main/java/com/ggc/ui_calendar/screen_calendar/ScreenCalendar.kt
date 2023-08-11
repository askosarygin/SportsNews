package com.ggc.ui_calendar.screen_calendar

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.R.font.font_inter_medium
import com.ggc.common.R.font.font_inter_regular
import com.ggc.common.R.string.apply
import com.ggc.common.R.string.content_description_next_month
import com.ggc.common.R.string.content_description_previous_month
import com.ggc.common.R.string.fri
import com.ggc.common.R.string.mon
import com.ggc.common.R.string.sat
import com.ggc.common.R.string.sun
import com.ggc.common.R.string.thu
import com.ggc.common.R.string.tue
import com.ggc.common.R.string.wed
import com.ggc.common.entities.MonthInfo
import com.ggc.common.theme.green
import com.ggc.common.theme.grey2
import com.ggc.common.theme.grey3
import com.ggc.common.theme.red
import com.ggc.common.theme.white
import com.ggc.common.ui_elements.AppText
import com.ggc.common.ui_elements.Grid
import com.ggc.ui_calendar.R.drawable.icon_calendar_arrow_left
import com.ggc.ui_calendar.R.drawable.icon_calendar_arrow_right

@Preview(showBackground = true)
@Composable
private fun Preview() {


    AppTopBarNavigation(
        matchOnClick = { /*TODO*/ },
        newsOnClick = { /*TODO*/ },
        notesOnClick = { /*TODO*/ },
        calendarOnClick = { /*TODO*/ },
        interactiveOnClick = { /*TODO*/ }
    ) {
        ScreenCalendar()
    }
}

@Composable
fun ScreenCalendar() {
    val monthInfo = MonthInfo(
        month = "December",
        "2022",
        dayCells = listOf(
            MonthInfo.DayCell(id = 0),
            MonthInfo.DayCell(id = 1),
            MonthInfo.DayCell(id = 2),
            MonthInfo.DayCell(id = 3),
            MonthInfo.DayCell(id = 4, dayInfo = MonthInfo.DayCell.DayInfo("1")),
            MonthInfo.DayCell(id = 5, dayInfo = MonthInfo.DayCell.DayInfo("2")),
            MonthInfo.DayCell(id = 6, dayInfo = MonthInfo.DayCell.DayInfo("3")),
            MonthInfo.DayCell(id = 7, dayInfo = MonthInfo.DayCell.DayInfo("4")),
            MonthInfo.DayCell(id = 8, dayInfo = MonthInfo.DayCell.DayInfo("5")),
            MonthInfo.DayCell(id = 9, dayInfo = MonthInfo.DayCell.DayInfo("6")),
            MonthInfo.DayCell(id = 10, dayInfo = MonthInfo.DayCell.DayInfo("7")),
            MonthInfo.DayCell(id = 11, dayInfo = MonthInfo.DayCell.DayInfo("8")),
            MonthInfo.DayCell(id = 12, dayInfo = MonthInfo.DayCell.DayInfo("9")),
            MonthInfo.DayCell(id = 13, dayInfo = MonthInfo.DayCell.DayInfo("10")),
            MonthInfo.DayCell(id = 14, dayInfo = MonthInfo.DayCell.DayInfo("11")),
            MonthInfo.DayCell(id = 15, dayInfo = MonthInfo.DayCell.DayInfo("12")),
            MonthInfo.DayCell(id = 16, dayInfo = MonthInfo.DayCell.DayInfo("13")),
            MonthInfo.DayCell(id = 17, dayInfo = MonthInfo.DayCell.DayInfo("14")),
            MonthInfo.DayCell(id = 18, dayInfo = MonthInfo.DayCell.DayInfo("15")),
            MonthInfo.DayCell(id = 19, dayInfo = MonthInfo.DayCell.DayInfo("16")),
            MonthInfo.DayCell(id = 20, dayInfo = MonthInfo.DayCell.DayInfo("17")),
            MonthInfo.DayCell(id = 21, dayInfo = MonthInfo.DayCell.DayInfo("18")),
            MonthInfo.DayCell(id = 22, dayInfo = MonthInfo.DayCell.DayInfo("19")),
            MonthInfo.DayCell(id = 23, dayInfo = MonthInfo.DayCell.DayInfo("20")),
            MonthInfo.DayCell(id = 24, dayInfo = MonthInfo.DayCell.DayInfo("21")),
            MonthInfo.DayCell(id = 25, dayInfo = MonthInfo.DayCell.DayInfo("22")),
            MonthInfo.DayCell(id = 26, dayInfo = MonthInfo.DayCell.DayInfo("23")),
            MonthInfo.DayCell(id = 27, dayInfo = MonthInfo.DayCell.DayInfo("24")),
            MonthInfo.DayCell(id = 28, dayInfo = MonthInfo.DayCell.DayInfo("25")),
            MonthInfo.DayCell(id = 29, dayInfo = MonthInfo.DayCell.DayInfo("26")),
            MonthInfo.DayCell(id = 30, dayInfo = MonthInfo.DayCell.DayInfo("27")),
            MonthInfo.DayCell(id = 31, dayInfo = MonthInfo.DayCell.DayInfo("28")),
            MonthInfo.DayCell(id = 32, dayInfo = MonthInfo.DayCell.DayInfo("29")),
            MonthInfo.DayCell(id = 33, dayInfo = MonthInfo.DayCell.DayInfo("30")),
            MonthInfo.DayCell(id = 34),
            MonthInfo.DayCell(id = 35),
            MonthInfo.DayCell(id = 36),
            MonthInfo.DayCell(id = 37),
            MonthInfo.DayCell(id = 38),
            MonthInfo.DayCell(id = 39),
            MonthInfo.DayCell(id = 40),
            MonthInfo.DayCell(id = 41)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        contentAlignment = Alignment.Center
    ) {
        Calendar(
            monthInfo = monthInfo,
            previousMonthOnClick = { /*TODO*/ },
            nextMonthOnClick = { /*TODO*/ },
            applyOnClick = { /*TODO*/ }
        )
    }
}

@Composable
private fun Calendar(
    monthInfo: MonthInfo,
    previousMonthOnClick: () -> Unit,
    nextMonthOnClick: () -> Unit,
    applyOnClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(color = white, shape = RoundedCornerShape(size = 8.dp))
            .padding(all = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalendarHeader(
            month = monthInfo.month,
            year = monthInfo.year,
            previousMonthOnClick = { /*TODO*/ },
            nextMonthOnClick = { /*TODO*/ }
        )

        CalendarBody(monthInfo = monthInfo)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            ButtonApply(onClick = applyOnClick)
        }
    }
}

@Composable
private fun ButtonApply(
    onClick: () -> Unit
) {
    AppText(
        modifier = Modifier
            .background(color = red, shape = RoundedCornerShape(size = 4.dp))
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(onClick = onClick),
        text = stringResource(id = apply),
        fontSize = 12.sp,
        color = white,
        font = font_inter_regular
    )
}

@Composable
private fun CalendarBody(
    monthInfo: MonthInfo
) {
    Grid(
        quantityCellsInWidth = 7,
        spaceY = 4.dp
    ) {
        DayOfWeek(resId = sun)
        DayOfWeek(resId = mon)
        DayOfWeek(resId = tue)
        DayOfWeek(resId = wed)
        DayOfWeek(resId = thu)
        DayOfWeek(resId = fri)
        DayOfWeek(resId = sat)

        monthInfo.dayCells.forEach { dayCell ->
            CalendarCell(
                dayCell = dayCell,
                onClick = {/*todo*/ }
            )
        }
    }
}

@Composable
private fun CalendarHeader(
    month: String,
    year: String,
    previousMonthOnClick: () -> Unit,
    nextMonthOnClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
        ) {
            AppText(text = month, fontSize = 14.sp, color = green, font = font_inter_medium)
            AppText(text = year, fontSize = 14.sp, color = green, font = font_inter_medium)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            Image(
                modifier = Modifier.clickable(onClick = previousMonthOnClick),
                painter = painterResource(id = icon_calendar_arrow_left),
                contentDescription = stringResource(id = content_description_previous_month)
            )
            Image(
                modifier = Modifier.clickable(onClick = nextMonthOnClick),
                painter = painterResource(id = icon_calendar_arrow_right),
                contentDescription = stringResource(id = content_description_next_month)
            )
        }
    }
}

@Composable
private fun DayOfWeek(
    @StringRes resId: Int
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AppText(
            text = stringResource(id = resId),
            fontSize = 12.sp,
            color = green,
            font = font_inter_regular
        )
    }
}

@Composable
private fun CalendarCell(
    dayCell: MonthInfo.DayCell,
    onClick: () -> Unit
) {
    Box {
        dayCell.dayInfo?.let { dayInfo ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = if (dayInfo.selection.start || dayInfo.selection.end) {
                            grey3
                        } else {
                            if (dayInfo.selection.intermediate) {
                                grey2
                            } else {
                                Color.Transparent
                            }
                        },
                        shape = if (dayInfo.selection.start && dayInfo.selection.end) {
                            RoundedCornerShape(size = 8.dp)
                        } else {
                            if (dayInfo.selection.start) {
                                RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                            } else {
                                if (dayInfo.selection.end) {
                                    RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                                } else {
                                    RectangleShape
                                }
                            }
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                AppText(
                    text = dayInfo.number,
                    fontSize = 12.sp,
                    color = green,
                    font = font_inter_regular
                )
            }
        }
    }
}