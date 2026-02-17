package com.app.taskflow.di


import android.content.Context
import androidx.room.Room
import com.app.taskflow.data.local.TaskDao
import com.app.taskflow.data.local.TaskDatabase
import com.app.taskflow.data.repository.TaskRepositoryImpl
import com.app.taskflow.domain.repository.TaskRepository
import com.app.taskflow.domain.usecase.AddTaskUseCase
import com.app.taskflow.domain.usecase.GetTasksUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Provides app dependencies.
 * Hilt automatically injects them where needed.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TaskDatabase =
        Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "task_db"
        ).build()

    @Provides
    fun provideDao(db: TaskDatabase) = db.taskDao()

    @Provides
    fun provideRepository(
        dao: TaskDao
    ): TaskRepository =
        TaskRepositoryImpl(dao)

    @Provides
    fun provideGetTasksUseCase(repo: TaskRepository) =
        GetTasksUseCase(repo)

    @Provides
    fun provideAddTaskUseCase(repo: TaskRepository) =
        AddTaskUseCase(repo)
}
