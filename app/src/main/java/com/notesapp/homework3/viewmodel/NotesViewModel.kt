package com.notesapp.homework3.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.notesapp.homework3.model.Notes
import com.notesapp.homework3.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

/*@HiltViewModel-It will create a dependency for ViewModel and Hilt will return that later,
with the help of this annotation,
we can provide instances of viewModel in the entire application.
 */


/* @Inject-This annotation is used to perform the injection.
It is used to inject the dependencies into dependent classes.
The dependencies can be injected through a constructor, field or method.*/


@HiltViewModel
class NotesViewModel @Inject constructor( //constructor injection
    private val noteRepository: NoteRepository
) : ViewModel() {
    //Database Operations in view model

    fun insert(note: Notes) {
        Log.e("DEBUG","insert is called in viewmodel")
        return noteRepository.insert(note)
    }


    fun update(note: Notes) {
        Log.e("DEBUG","update is called in viewmodel")
        noteRepository.update(note)
    }


    fun getAllNotes(): LiveData<List<Notes>> {
        Log.e("DEBUG", "View model getallnotes")
        return noteRepository.getAllNotes()
    }


}