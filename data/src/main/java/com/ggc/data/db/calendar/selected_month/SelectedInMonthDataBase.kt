package com.ggc.data.db.calendar.selected_month

import androidx.room.*

private const val TABLE_NAME_SELECTED_IN_MONTH = "selected_in_month"
private const val MONTH_NUMBER = "month_number"
private const val YEAR_NUMBER = "year_number"
private const val SELECTED_DAY_START = "selected_day_start"
private const val SELECTED_DAY_END = "selected_day_end"

@Entity(tableName = TABLE_NAME_SELECTED_IN_MONTH)
data class SelectedInMonthDatabaseClass(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = MONTH_NUMBER) val monthNumber: Int,
    @ColumnInfo(name = YEAR_NUMBER) val yearNumber: Int,
    @ColumnInfo(name = SELECTED_DAY_START) val selectedDayStart: Int,
    @ColumnInfo(name = SELECTED_DAY_END) val selectedDayEnd: Int
)

@Dao
interface SelectedInMonthDAO {
    @Insert
    fun add(selectedInMonthDatabaseClass: SelectedInMonthDatabaseClass)

    @Query("DELETE FROM $TABLE_NAME_SELECTED_IN_MONTH WHERE id=1")
    fun delete()

    @Query("SELECT * FROM $TABLE_NAME_SELECTED_IN_MONTH WHERE id=1")
    fun get(): SelectedInMonthDatabaseClass
}

@Database(entities = [SelectedInMonthDatabaseClass::class], version = 1, exportSchema = false)
abstract class SelectedInMonthDatabase : RoomDatabase() {
    abstract fun selectedInMonthDAO(): SelectedInMonthDAO
}

