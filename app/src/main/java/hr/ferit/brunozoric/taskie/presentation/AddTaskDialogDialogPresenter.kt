package hr.ferit.brunozoric.taskie.presentation

import hr.ferit.brunozoric.taskie.common.RESPONSE_OK
import hr.ferit.brunozoric.taskie.common.displayToast
import hr.ferit.brunozoric.taskie.domain.addTask.AddTaskUseCase
import hr.ferit.brunozoric.taskie.model.BackendTask
import hr.ferit.brunozoric.taskie.model.request.AddTaskRequest
import hr.ferit.brunozoric.taskie.networking.interactors.TaskieInteractor
import hr.ferit.brunozoric.taskie.ui.tasklist.fragment.AddTaskDilogContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTaskDialogDialogPresenter (private val addTaskUseCase: AddTaskUseCase): AddTaskDilogContract.Presenter{

    private lateinit var view: AddTaskDilogContract.View

    override fun setView(view: AddTaskDilogContract.View) {
        this.view = view
    }

    override fun onAddTask(task: AddTaskRequest) {
        addTaskUseCase.execute(task, ::handleOkResponse, ::handleSomethingWentWrong)
    }

    private fun handleOkResponse(task: BackendTask) = task.run { view.onTaskAdded(this) }

    private fun handleSomethingWentWrong(error: Throwable?) {
        view.onTaskAddFailed()
    }
}