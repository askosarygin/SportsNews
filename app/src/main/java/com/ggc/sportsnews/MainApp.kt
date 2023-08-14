package com.ggc.sportsnews

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.ggc.data.RepositoryImpl
import com.ggc.data.appdata.AppData
import com.ggc.data.appdata.AppDataImpl
import com.ggc.data.db.calendar.month_info.MonthsInfoUtilImpl
import com.ggc.data.db.calendar.selected_month.SelectedInMonthDAO
import com.ggc.data.db.calendar.selected_month.SelectedInMonthDBStorageImpl
import com.ggc.data.db.calendar.selected_month.SelectedInMonthDatabase
import com.ggc.data.db.network.NetworkImpl
import com.ggc.data.db.notes.NotesDAO
import com.ggc.data.db.notes.NotesDBStorage
import com.ggc.data.db.notes.NotesDBStorageImpl
import com.ggc.data.db.notes.NotesDatabase
import com.ggc.domain.InteractorImpl
import com.ggc.domain.usecases.AddNoteToDBUseCase
import com.ggc.domain.usecases.AddSelectedInMonthUseCase
import com.ggc.domain.usecases.DeleteNoteByIdFromDBUseCase
import com.ggc.domain.usecases.GetAllMatchesUseCase
import com.ggc.domain.usecases.GetAllNewsUseCase
import com.ggc.domain.usecases.GetAllNotesFromDBUseCase
import com.ggc.domain.usecases.GetMonthInfoUseCase
import com.ggc.domain.usecases.GetNewsByIdUseCase
import com.ggc.domain.usecases.GetNoteByIdFromDBUseCase
import com.ggc.domain.usecases.GetSelectedInMonthUseCase
import com.ggc.domain.usecases.GetTeamHistoryInfoByIdUseCase

class MainApp : Application() {
    private val dbNotesName = "SportsNewsDBNotes"
    private val dbSelectedInMonth = "SportsNewsDBSelectedInMonth"
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var loadBitmap: RequestManager
    private lateinit var notesDAO: NotesDAO
    private lateinit var selectedInMonthDAO: SelectedInMonthDAO

    private lateinit var appData: AppDataImpl
    private lateinit var notesDB: NotesDBStorage
    private lateinit var network: NetworkImpl
    private lateinit var monthStorage: MonthsInfoUtilImpl
    private lateinit var selectedInMonthDB: SelectedInMonthDBStorageImpl

    private lateinit var repository: RepositoryImpl

    lateinit var interactor: InteractorImpl

    override fun onCreate() {
        super.onCreate()

        sharedPreferences = this.getSharedPreferences(
            AppData.APP_DATA_SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
        loadBitmap = Glide.with(this)
        notesDAO = Room.databaseBuilder(
            this,
            NotesDatabase::class.java,
            dbNotesName
        ).build().notesDAO()

        selectedInMonthDAO = Room.databaseBuilder(
            this,
            SelectedInMonthDatabase::class.java,
            dbSelectedInMonth
        ).build().selectedInMonthDAO()

        appData = AppDataImpl(sharedPreferences)
        network = NetworkImpl(resources)
        notesDB = NotesDBStorageImpl(notesDAO)
        monthStorage = MonthsInfoUtilImpl()
        selectedInMonthDB = SelectedInMonthDBStorageImpl(selectedInMonthDAO)

        repository = RepositoryImpl(
            appData,
            notesDB,
            network,
            monthStorage,
            selectedInMonthDB
        )

        interactor = InteractorImpl(
            AddNoteToDBUseCase(repository),
            DeleteNoteByIdFromDBUseCase(repository),
            GetAllNotesFromDBUseCase(repository),
            GetNoteByIdFromDBUseCase(repository),
            GetAllMatchesUseCase(repository),
            GetAllNewsUseCase(repository),
            GetNewsByIdUseCase(repository),
            GetTeamHistoryInfoByIdUseCase(repository),
            GetMonthInfoUseCase(repository),
            GetSelectedInMonthUseCase(repository),
            AddSelectedInMonthUseCase(repository)
        )
    }
}