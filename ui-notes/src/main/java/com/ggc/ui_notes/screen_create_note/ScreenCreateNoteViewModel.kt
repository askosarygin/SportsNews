package com.ggc.ui_notes.screen_create_note

import androidx.lifecycle.viewModelScope
import com.ggc.common.entities.Note
import com.ggc.common.utils.SportsNewsViewModel
import com.ggc.common.utils.SportsNewsViewModelSingleLifeEvent
import com.ggc.domain.Interactor
import com.ggc.ui_notes.screen_create_note.ScreenCreateNoteViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenNotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenCreateNoteViewModel(
    private val interactor: Interactor
) : SportsNewsViewModel<ScreenCreateNoteViewModel.Model>(Model()) {
    private var creatingNote: Boolean = false

    fun buttonBackPressed() {
        updateNavigationEvent(Model.NavigationSingleLifeEvent(ScreenNotes))
    }

    fun buttonCreatePressed() {
        viewModelScope.launch(Dispatchers.IO) {
            if (model.value.title.isNotBlank() && model.value.text.isNotBlank()) {
                if (!creatingNote) {
                    creatingNote = true
                    val resultAdd = interactor.addNote(
                        Note(
                            title = model.value.title,
                            text = model.value.text
                        )
                    )
                    if (resultAdd) {
                        updateNavigationEvent(Model.NavigationSingleLifeEvent(ScreenNotes))
                    } else {
                        creatingNote = false
                    }
                }
            }
        }
    }

    fun buttonClearPressed() {
        updateTitle("")
        updateText("")
    }

    fun changeTitle(newTitle: String) {
        updateTitle(newTitle)
    }

    fun changeText(newText: String) {
        updateText(newText)
    }

    data class Model(
        val title: String = "",
        val text: String = "",
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : SportsNewsViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {
                ScreenNotes
            }
        }
    }

    private fun updateTitle(title: String) {
        update { it.copy(title = title) }
    }

    private fun updateText(text: String) {
        update { it.copy(text = text) }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update { it.copy(navigationEvent = navigationEvent) }
    }
}