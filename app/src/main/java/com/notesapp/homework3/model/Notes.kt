package com.notesapp.homework3.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "notes")
@Parcelize //pass data with navArgs
data class Notes (
    val title:String?,
    val body:String
        ):Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}