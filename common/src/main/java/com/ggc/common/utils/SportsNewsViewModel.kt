package com.ggc.common.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

open class SportsNewsViewModel<MODEL>(
    model: MODEL
) : ViewModel() {
    private val _model = MutableStateFlow(model)
    val model: StateFlow<MODEL> = _model

    protected fun update(function: (MODEL) -> MODEL) {
        _model.update {
            function(it)
        }
    }
}