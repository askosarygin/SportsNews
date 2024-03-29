package com.ggc.data

import com.ggc.common.entities.MatchInfo
import com.ggc.common.entities.MonthInfo
import com.ggc.common.entities.NewsInfo
import com.ggc.common.entities.NoteDB
import com.ggc.common.entities.SelectedInMonthDB
import com.ggc.common.entities.TeamHistoryInfo
import com.ggc.data.appdata.AppData
import com.ggc.data.db.calendar.month_info.MonthInfoUtil
import com.ggc.data.db.calendar.selected_month.SelectedInMonthDBStorage
import com.ggc.data.db.network.Network
import com.ggc.data.db.notes.NotesDBStorage
import com.ggc.domain.Repository
import java.util.Calendar

class RepositoryImpl(
    private val appData: AppData,
    private val notesDB: NotesDBStorage,
    private val network: Network,
    private val monthInfoUtil: MonthInfoUtil,
    private val selectedInMonthDBStorage: SelectedInMonthDBStorage
): Repository {
    override suspend fun getAllNotes(): List<NoteDB> {
        return notesDB.getAllNotes()
    }

    override suspend fun addNote(noteDB: NoteDB): Boolean {
        return notesDB.addNote(noteDB)
    }

    override suspend fun deleteNoteById(id: Long): Boolean {
        return notesDB.deleteNoteById(id)
    }

    override suspend fun getNoteById(id: Long): NoteDB {
        return notesDB.getNoteById(id)
    }

    override suspend fun getAllMatches(): List<MatchInfo> {
        return network.getAllMatches()
    }

    override suspend fun getTeamHistoryInfoById(id: Long): TeamHistoryInfo {
        return network.getTeamHistoryInfoById(id)
    }

    override suspend fun getAllNews(): List<NewsInfo> {
        return network.getAllNews()
    }

    override suspend fun getNewsById(id: Long): NewsInfo {
        return network.getNewsById(id)
    }

    override suspend fun getMonthInfo(month: Calendar): MonthInfo {
        return monthInfoUtil.getMonthInfo(month)
    }

    override suspend fun addSelectedInMonth(selectedInMonthDB: SelectedInMonthDB): Boolean {
        return selectedInMonthDBStorage.add(selectedInMonthDB)
    }

    override suspend fun deleteSelectedMonth(): Boolean {
        return selectedInMonthDBStorage.deleteSelectedMonth()
    }

    override suspend fun getSelectedInMonth(): SelectedInMonthDB {
        return selectedInMonthDBStorage.get()
    }
}