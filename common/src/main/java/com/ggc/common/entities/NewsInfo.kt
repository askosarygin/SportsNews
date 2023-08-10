package com.ggc.common.entities

import androidx.compose.ui.graphics.ImageBitmap

data class NewsInfo(
    val id: Long,
    val newsImage: ImageBitmap,
    val title: String,
    val text: String
)
