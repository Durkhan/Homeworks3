package com.notesapp.homework3.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.notesapp.homework3.database.NotesDao
import com.notesapp.homework3.model.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class NoteRepository @Inject constructor(val noteDao:NotesDao) {


    //function to insert note in database
    fun insert(note: Notes) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.insertNote(note)
        }
    }




    //function to update note in database
    fun update(note: Notes) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.updateNote(note)
            Log.e("DEBUG", "update is called in repo")

        }
    }


    //function to get all notes in database
    fun getAllNotes(): LiveData<List<Notes>> {
        return noteDao.getAllNotes()
    }
}
