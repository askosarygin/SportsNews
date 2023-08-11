package com.ggc.common.utils

import java.util.concurrent.atomic.AtomicBoolean

open class SportsNewsViewModelSingleLifeEvent<EVENT>(
    private val event: EVENT
) : SportsNewsViewModelEvent<EVENT>(event) {
    private val processed = AtomicBoolean(false)

    override fun use(doEvent: (EVENT) -> Unit) {
        if (!processed.getAndSet(true)) {
            super.use(doEvent)
        }
    }
}