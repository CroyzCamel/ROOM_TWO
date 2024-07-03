package com.example.room_two

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class User(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    val name: String,
)
