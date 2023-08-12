package com.ggc.common.navigation

import java.io.Serializable

class NavArgs {
    data class ScreenHistory(
        val teamId: Long
    ) : Serializable

    data class ScreenNewsArticle(
        val newsId: Long
    ) : Serializable

    data class ScreenEditNote(
        val noteId: Long
    ) : Serializable
}
