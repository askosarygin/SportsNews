package com.ggc.common.utils

open class SportsNewsViewModelEvent<EVENT>(
    private val event: EVENT
) {
    open fun use(doEvent: (EVENT) -> Unit) {
        doEvent(event)
    }
}