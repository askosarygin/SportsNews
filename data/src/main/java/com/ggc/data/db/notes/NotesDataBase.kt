package com.ggc.data.db.notes

import androidx.room.*

private const val TABLE_NAME_NOTES = "notes"
private const val TITLE = "question_text"
private const val TEXT = "correct_answer"

@Entity(tableName = TABLE_NAME_NOTES)
data class NoteDatabaseClass(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = TITLE) val title: String,
    @ColumnInfo(name = TEXT) val text: String
)

@Dao
interface NotesDAO {
    @Insert
    fun add(noteDatabaseClass: NoteDatabaseClass)

    @Query("DELETE FROM $TABLE_NAME_NOTES WHERE id=(:id)")
    fun deleteById(id: Long)

    @Query("SELECT * FROM $TABLE_NAME_NOTES")
    fun getAll(): List<NoteDatabaseClass>

    @Query("SELECT * FROM $TABLE_NAME_NOTES WHERE id=(:id)")
    fun getById(id: Long): NoteDatabaseClass
}

@Database(entities = [NoteDatabaseClass::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDAO(): NotesDAO
}

