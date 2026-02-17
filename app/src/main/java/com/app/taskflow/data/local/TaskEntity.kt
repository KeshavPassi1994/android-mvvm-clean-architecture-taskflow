package com.app.taskflow.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Database entity.
 * Represents how data is stored locally.
 */
@Entity(tableName = "tasks")
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val isCompleted: Boolean
)
