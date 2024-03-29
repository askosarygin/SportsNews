package com.ggc.common.entities

import androidx.compose.ui.graphics.ImageBitmap

data class NewsInfo(
    val id: Long = 0L,
    val newsImage: ImageBitmap? = null,
    val title: String = "",
    val text: String = ""
)
