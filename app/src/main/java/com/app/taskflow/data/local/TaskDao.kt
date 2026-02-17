package com.app.taskflow.data.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * DAO = Database Access Object
 * Handles database queries.
 */
@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    suspend fun getTasks(): List<TaskEntity>

    @Insert
    suspend fun insert(task: TaskEntity)
}
