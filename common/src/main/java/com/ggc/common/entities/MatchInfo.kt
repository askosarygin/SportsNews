package com.ggc.common.entities

import androidx.compose.ui.graphics.ImageBitmap

data class MatchInfo(
    val teamOneLogo: ImageBitmap,
    val teamOneName: String,
    val teamTwoLogo: ImageBitmap,
    val teamTwoName: String,
    val date: String,
    val time: String
)
