package com.app.taskflow.domain.model

/**
 * Domain model used across the app.
 * This layer should NOT depend on Android framework.
 */
data class Task(
    val id: Int = 0,
    val title: String,
    val isCompleted: Boolean = false
)
