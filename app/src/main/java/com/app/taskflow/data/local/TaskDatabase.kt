package com.app.taskflow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Main Room database holder.
 */
@Database(
    entities = [TaskEntity::class],
    version = 1
)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}
