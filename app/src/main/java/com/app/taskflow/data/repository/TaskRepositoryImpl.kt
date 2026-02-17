package com.app.taskflow.data.repository

import com.app.taskflow.data.local.TaskDao
import com.app.taskflow.data.local.TaskEntity
import com.app.taskflow.domain.model.Task
import com.app.taskflow.domain.repository.TaskRepository


/**
 * Repository implementation.
 * Converts database models into domain models.
 */
class TaskRepositoryImpl(
    private val dao: TaskDao
) : TaskRepository {

    override suspend fun getTasks(): List<Task> {
        return dao.getTasks().map {
            Task(
                id = it.id,
                title = it.title,
                isCompleted = it.isCompleted
            )
        }
    }

    override suspend fun addTask(task: Task) {
        dao.insert(
            TaskEntity(
                title = task.title,
                isCompleted = task.isCompleted
            )
        )
    }
}
