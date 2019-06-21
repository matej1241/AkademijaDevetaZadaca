package hr.ferit.brunozoric.taskie.domain.addTask

import hr.ferit.brunozoric.taskie.common.ErrorLambda
import hr.ferit.brunozoric.taskie.common.SuccessLambda
import hr.ferit.brunozoric.taskie.model.BackendTask
import hr.ferit.brunozoric.taskie.model.request.AddTaskRequest
import hr.ferit.brunozoric.taskie.persistence.addTask.AddTaskRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTaskUseCaseImpl(private val addTaskRepository: AddTaskRepository):AddTaskUseCase{
    override fun execute(task: AddTaskRequest, onSuccess: SuccessLambda<BackendTask>, onFailure: ErrorLambda) {
        addTaskRepository.addTask(task).enqueue(object : Callback<BackendTask> {
            override fun onResponse(call: Call<BackendTask>, response: Response<BackendTask>) {
                if (response.isSuccessful) response.body()?.run(onSuccess)
                response.errorBody()?.run { onFailure(IllegalStateException("Something went wrong")) }
            }
            override fun onFailure(call: Call<BackendTask>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}