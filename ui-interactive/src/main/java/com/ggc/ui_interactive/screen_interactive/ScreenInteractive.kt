package com.ggc.ui_interactive.screen_interactive

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ggc.common.AppTopBarNavigation

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
        ScreenInteractive()
    }
}

@Composable
fun ScreenInteractive() {

}