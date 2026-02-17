package com.app.taskflow.domain.repository

import com.app.taskflow.domain.model.Task


/**
 * Repository contract.
 * Domain layer only knows this interface,
 * not the implementation details.
 */
interface TaskRepository {

    suspend fun getTasks(): List<Task>

    suspend fun addTask(task: Task)
}
