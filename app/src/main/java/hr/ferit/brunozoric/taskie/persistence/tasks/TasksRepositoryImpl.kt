package hr.ferit.brunozoric.taskie.persistence.tasks

import hr.ferit.brunozoric.taskie.model.response.GetTasksResponse
import hr.ferit.brunozoric.taskie.networking.TaskieApiService
import retrofit2.Call

class TasksRepositoryImpl(private val authService: TaskieApiService):TasksRepository {
    override fun getTasks(): Call<GetTasksResponse> = authService.getTasks()
}