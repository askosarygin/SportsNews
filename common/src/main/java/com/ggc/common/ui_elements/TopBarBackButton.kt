package com.ggc.common.ui_elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.R.drawable.icon_arrow_left
import com.ggc.common.R.font.font_inter_regular
import com.ggc.common.R.string.content_description_back_button
import com.ggc.common.theme.blueLight
import com.ggc.common.theme.white

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
        TopBarBackButton(
            "History",
            {}
        )
    }
}

@Composable
fun TopBarBackButton(
    headerName: String,
    backButtonClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = blueLight),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            AppText(
                modifier = Modifier.padding(vertical = 13.dp),
                text = headerName,
                fontSize = 12.sp,
                color = white,
                font = font_inter_regular
            )
        }
        Image(
            modifier = Modifier.padding(start = 10.dp)
                .clickable(
                    onClick = backButtonClicked
                ),
            painter = painterResource(id = icon_arrow_left),
            contentDescription = stringResource(id = content_description_back_button)
        )
    }
}