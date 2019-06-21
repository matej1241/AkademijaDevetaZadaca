package hr.ferit.brunozoric.taskie.persistence.addTask

import hr.ferit.brunozoric.taskie.model.BackendTask
import hr.ferit.brunozoric.taskie.model.request.AddTaskRequest
import retrofit2.Call

interface AddTaskRepository {
    fun addTask(task: AddTaskRequest): Call<BackendTask>
}