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
/* @Module : It is used to create an object for any component dependency,
mostly used for the third party or where constructor and field injection cannot be performed.
Tell hilt that this is a module.

@InstallIn- Installin tells the container where the bindings are.
@Installn (SingletonComponent::class) helps activity component class’s dependency to inject via hilt.
 This annotation means that all of the dependencies in this Module are available in all of the app’s activities.
 @Singleton- It will create a singleton instance for a dependency,
  which will be shared across the application.
  This makes the application container always provide the same instance regardless of whether the type
   of dependencies we are using is the same or a different one.

 */

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