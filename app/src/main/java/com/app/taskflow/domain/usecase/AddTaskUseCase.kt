package com.app.taskflow.domain.usecase

import com.app.taskflow.domain.model.Task
import com.app.taskflow.domain.repository.TaskRepository


/**
 * Adds a new task into database.
 */
class AddTaskUseCase(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(task: Task) {
        repository.addTask(task)
    }
}
