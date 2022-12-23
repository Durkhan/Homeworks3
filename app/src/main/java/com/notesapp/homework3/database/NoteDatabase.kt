package com.notesapp.homework3.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.notesapp.homework3.model.Notes


@Database(
    entities = [Notes::class],
    version =1,
    exportSchema = false
)
    abstract class NoteDatabase: RoomDatabase() {
        abstract fun noteDao(): NotesDao
    }
