package com.notesapp.homework3.module

import android.app.Application
import androidx.room.Room
import com.notesapp.homework3.database.NoteDatabase
import com.notesapp.homework3.database.NotesDao
import com.notesapp.homework3.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providesAppDatabase(app:Application):NoteDatabase{
        return Room.databaseBuilder(app,NoteDatabase::class.java,"note_database").build()
    }


    @Singleton
    @Provides
    fun providesNoteDao(db: NoteDatabase): NotesDao {
        return db.noteDao()
    }


    @Provides
    fun providesRepository(noteDao: NotesDao):NoteRepository{
        return NoteRepository(noteDao)
    }

}