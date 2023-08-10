package com.ggc.ui_notes.screen_create_note

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.R.font.font_inter_black
import com.ggc.common.R.font.font_inter_semi_bold
import com.ggc.common.R.string.clear
import com.ggc.common.R.string.create
import com.ggc.common.R.string.create_note
import com.ggc.common.R.string.note_text
import com.ggc.common.R.string.note_title
import com.ggc.common.R.string.text
import com.ggc.common.R.string.title
import com.ggc.common.theme.green
import com.ggc.common.theme.grey4
import com.ggc.common.theme.white
import com.ggc.common.theme.whiteDark
import com.ggc.common.theme.yellow
import com.ggc.common.ui_elements.AppText
import com.ggc.common.ui_elements.TopBarBackButton

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
        Column {
            TopBarBackButton(
                headerName = stringResource(id = create_note),
                backButtonClicked = { /*TODO*/ }
            )

            ScreenCreateNote()
        }
    }
}

@Composable
fun ScreenCreateNote() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.weight(weight = 1f)
        ) {
            Column {
                TitleHeader()
                TitleTextField(
                    value = "",
                    onValueChange = { /*TODO*/ }
                )
                TextHeader()
                TextTextField(
                    modifier = Modifier.weight(1f),
                    value = "",
                    onValueChange = { /*TODO*/ }
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(vertical = 25.dp, horizontal = 34.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 50.dp)
        ) {
            ScreenNotesButton(
                modifier = Modifier.weight(weight = 1f),
                text = stringResource(id = create),
                onClick = { /*TODO*/ }
            )
            ScreenNotesButton(
                modifier = Modifier.weight(weight = 1f),
                text = stringResource(id = clear),
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Composable
private fun ScreenNotesButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    AppText(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = yellow,
                shape = RoundedCornerShape(size = 6.dp)
            )
            .padding(vertical = 14.dp)
            .clickable(onClick = onClick),
        text = text,
        fontSize = 11.sp,
        color = green,
        font = font_inter_black,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun TitleHeader(
    modifier: Modifier = Modifier
) {
    AppText(
        modifier = modifier
            .background(color = whiteDark)
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp, bottom = 5.dp),
        text = stringResource(id = title),
        fontSize = 11.sp,
        color = green,
        font = font_inter_semi_bold
    )
}

@Composable
private fun TitleTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier
            .background(color = white)
            .fillMaxWidth()
            .padding(vertical = 13.dp, horizontal = 10.dp),
        value = value,
        singleLine = true,
        onValueChange = onValueChange,
        decorationBox = {
            AppText(
                text = stringResource(id = note_title),
                fontSize = 11.sp,
                color = grey4,
                font = font_inter_semi_bold
            )
            it()
        }
    )
}

@Composable
private fun TextHeader(
    modifier: Modifier = Modifier
) {
    AppText(
        modifier = modifier
            .background(color = whiteDark)
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp, bottom = 5.dp),
        text = stringResource(id = text),
        fontSize = 11.sp,
        color = green,
        font = font_inter_semi_bold
    )
}

@Composable
private fun TextTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier
            .background(color = white)
            .fillMaxWidth()
            .padding(vertical = 13.dp, horizontal = 10.dp),
        value = value,
        onValueChange = onValueChange,
        decorationBox = {
            AppText(
                text = stringResource(id = note_text),
                fontSize = 11.sp,
                color = grey4,
                font = font_inter_semi_bold
            )
            it()
        }
    )
}