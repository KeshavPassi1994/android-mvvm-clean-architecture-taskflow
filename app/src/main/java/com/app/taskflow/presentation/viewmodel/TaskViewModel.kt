package com.app.taskflow.presentation.viewmodel


import androidx.lifecycle.*
import com.app.taskflow.domain.model.Task
import com.app.taskflow.domain.usecase.AddTaskUseCase
import com.app.taskflow.domain.usecase.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel connects UI with business logic.
 * Survives configuration changes.
 */
@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getTasks: GetTasksUseCase,
    private val addTask: AddTaskUseCase
) : ViewModel() {

    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> = _tasks

    /** Load tasks from repository */
    fun loadTasks() {
        viewModelScope.launch {
            _tasks.value = getTasks()
        }
    }

    /** Add new task */
    fun addNewTask(title: String) {
        viewModelScope.launch {
            addTask(Task(title = title))
            loadTasks()
        }
    }
}
