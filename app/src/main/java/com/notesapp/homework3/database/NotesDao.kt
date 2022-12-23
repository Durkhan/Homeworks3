package com.notesapp.homework3.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.notesapp.homework3.model.Notes

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Notes>>

    @Update
    suspend fun updateNote(note: Notes)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Notes)


}