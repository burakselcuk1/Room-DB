package com.example.myapplicationbvbv.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    val firstName: String,
    val lastName: String,
    val age: Int
    )