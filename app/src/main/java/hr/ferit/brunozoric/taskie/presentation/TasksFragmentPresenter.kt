package hr.ferit.brunozoric.taskie.presentation

import hr.ferit.brunozoric.taskie.common.RESPONSE_OK
import hr.ferit.brunozoric.taskie.common.displayToast
import hr.ferit.brunozoric.taskie.common.gone
import hr.ferit.brunozoric.taskie.domain.addTask.AddTaskUseCase
import hr.ferit.brunozoric.taskie.domain.register.RegisterUseCase
import hr.ferit.brunozoric.taskie.domain.tasks.TasksUseCase
import hr.ferit.brunozoric.taskie.model.response.GetTasksResponse
import hr.ferit.brunozoric.taskie.networking.interactors.TaskieInteractor
import hr.ferit.brunozoric.taskie.ui.tasklist.fragment.TasksFragmentContract
import kotlinx.android.synthetic.main.fragment_tasks.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TasksFragmentPresenter(private val taskUseCase: TasksUseCase): TasksFragmentContract.Presenter {

    private lateinit var view: TasksFragmentContract.View

    override fun setView(view: TasksFragmentContract.View) {
        this.view = view
    }

    override fun onGetAllTasks() {
        taskUseCase.execute(::handleOkResponse, ::handleSomethingWentWrong)
    }

    private fun handleOkResponse(response: GetTasksResponse) {
        response.notes?.run {
            view.onTaskListRecieved(this)
        }
    }

    private fun handleSomethingWentWrong(error: Throwable) = view.onGetTasksFailed()
}