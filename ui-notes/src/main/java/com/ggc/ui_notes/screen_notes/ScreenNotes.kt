package com.ggc.ui_notes.screen_notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ggc.common.AppTopBarNavigation
import com.ggc.common.R.font.font_inter_extra_bold
import com.ggc.common.R.font.font_inter_regular
import com.ggc.common.R.string.add
import com.ggc.common.R.string.content_description_note_add
import com.ggc.common.R.string.content_description_note_delete
import com.ggc.common.R.string.content_description_note_edit
import com.ggc.common.entities.Note
import com.ggc.common.theme.green2
import com.ggc.common.theme.red
import com.ggc.common.theme.white
import com.ggc.common.ui_elements.AppText
import com.ggc.ui_notes.R.drawable.icon_delete
import com.ggc.ui_notes.R.drawable.icon_pencil
import com.ggc.ui_notes.R.drawable.icon_plus

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
        ScreenNotes()
    }
}

@Composable
fun ScreenNotes() {
    val notes = listOf(
        Note(
            id = 0L,
            title = "Note tittle 1",
            text = "I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions."
        ),
        Note(
            id = 0L,
            title = "Note tittle 1",
            text = "I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions."
        ),
        Note(
            id = 0L,
            title = "Note tittle 1",
            text = "I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions."
        ),
        Note(
            id = 0L,
            title = "Note tittle 1",
            text = "I know I'm effective and I help the team succeed, I'm on the list of the best. I have enough experience and maturity to know that. Do I consider myself the best in the world? No. In my opinion, the best is someone who has gone all the way with their team and made them champions."
        )
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        ButtonAdd(onClick = { /*TODO*/ })

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            items(items = notes) { note ->
                NoteCard(
                    note = note,
                    editOnClick = { /*TODO*/ },
                    deleteOnClick = { /*TODO*/ }
                )
            }
        }
    }
}

@Composable
private fun ButtonAdd(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.CenterEnd
    ) {

        Row(
            modifier = Modifier
                .padding(end = 5.dp)
                .background(color = red, shape = RoundedCornerShape(size = 30.dp))
                .padding(vertical = 8.dp, horizontal = 15.dp)
                .clickable(onClick = onClick),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.padding(end = 10.dp),
                painter = painterResource(id = icon_plus),
                contentDescription = stringResource(id = content_description_note_add)
            )
            AppText(
                text = stringResource(id = add),
                fontSize = 12.sp,
                color = white,
                font = font_inter_extra_bold
            )
        }
    }
}

@Composable
private fun NoteCard(
    note: Note,
    editOnClick: () -> Unit,
    deleteOnClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(color = green2)
            .height(height = 110.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopEnd
    ) {
        Row(
            modifier = Modifier.padding(top = 5.dp, end = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(size = 22.dp)
                    .background(color = red, shape = CircleShape)
                    .clickable(onClick = editOnClick),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = icon_pencil),
                    contentDescription = stringResource(id = content_description_note_edit)
                )
            }
            Box(
                modifier = Modifier
                    .size(size = 22.dp)
                    .background(color = red, shape = CircleShape)
                    .clickable(onClick = deleteOnClick),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = icon_delete),
                    contentDescription = stringResource(id = content_description_note_delete)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 15.dp),
            verticalArrangement = Arrangement.spacedBy(space = 5.dp)
        ) {
            AppText(
                text = note.title,
                fontSize = 12.sp,
                color = white,
                font = font_inter_extra_bold
            )

            AppText(
                text = note.text,
                fontSize = 10.sp,
                color = white,
                font = font_inter_regular
            )
        }
    }
}