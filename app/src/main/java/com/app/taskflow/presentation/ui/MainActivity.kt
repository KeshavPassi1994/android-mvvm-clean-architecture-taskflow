package com.app.taskflow.presentation.ui


import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.taskflow.R
import com.app.taskflow.presentation.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main UI screen.
 * Observes ViewModel state.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Observe task updates
        viewModel.tasks.observe(this) {
            Log.d("TASK_LIST", it.toString())
        }

        viewModel.loadTasks()
    }
}
