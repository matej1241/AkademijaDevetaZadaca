package hr.ferit.brunozoric.taskie.persistence.tasks

import hr.ferit.brunozoric.taskie.model.response.GetTasksResponse
import retrofit2.Call

interface TasksRepository {
    fun getTasks(): Call<GetTasksResponse>
}