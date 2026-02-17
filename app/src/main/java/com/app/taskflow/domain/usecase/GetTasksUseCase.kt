package com.app.taskflow.domain.usecase

import com.app.taskflow.domain.repository.TaskRepository


/**
 * UseCase represents a single business action.
 * Keeps ViewModel clean and testable.
 */
class GetTasksUseCase(
    private val repository: TaskRepository
) {

    suspend operator fun invoke() =
        repository.getTasks()
}
