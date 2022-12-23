package com.notesapp.homework3

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/* Applying these annotations to application class,
It will trigger the Hilt code generation and in the process will create our App Component.
It is the parent component of the app, which means It is the parent component of the app,
 which means all the provided dependencies will be accessible by other components as well.*/

@HiltAndroidApp
class NotesApp:Application() {
}