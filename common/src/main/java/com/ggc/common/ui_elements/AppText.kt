package com.ggc.common.ui_elements

import androidx.annotation.FontRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit


@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit,
    color: Color,
    @FontRes font: Int
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        fontFamily = FontFamily(Font(resId = font))
    )
}