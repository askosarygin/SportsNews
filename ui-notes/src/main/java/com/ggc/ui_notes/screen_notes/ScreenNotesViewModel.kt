package com.ggc.ui_notes.screen_notes

import androidx.lifecycle.viewModelScope
import com.ggc.common.entities.Note
import com.ggc.common.utils.SportsNewsViewModel
import com.ggc.common.utils.SportsNewsViewModelSingleLifeEvent
import com.ggc.domain.Interactor
import com.ggc.ui_notes.screen_notes.ScreenNotesViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenCreateNote
import com.ggc.ui_notes.screen_notes.ScreenNotesViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenEditNote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenNotesViewModel(
    private val interactor: Interactor
) : SportsNewsViewModel<ScreenNotesViewModel.Model>(Model()) {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val notes = interactor.getAllNotes()
            updateNotes(notes)
        }
    }

    fun buttonCreateNotePressed() {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationInfo(ScreenCreateNote)
            )
        )
    }

    fun buttonEditNotePressed(noteId: Long) {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationInfo(
                    ScreenEditNote,
                    noteId
                )
            )
        )
    }

    fun buttonDeleteNotePressed(noteId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.deleteNoteById(noteId)
            val notes = interactor.getAllNotes()
            updateNotes(notes)
        }
    }

    data class Model(
        val notes: List<Note> = listOf(),
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigationInfo: NavigationInfo
        ) : SportsNewsViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationInfo>(
            navigationInfo
        ) {
            data class NavigationInfo(
                val navigateTo: NavigationDestination,
                val selectedNoteId: Long = 0L
            )

            enum class NavigationDestination {
                ScreenCreateNote,
                ScreenEditNote
            }
        }
    }

    private fun updateNotes(notes: List<Note>) {
        update { it.copy(notes = notes) }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update { it.copy(navigationEvent = navigationEvent) }
    }
}