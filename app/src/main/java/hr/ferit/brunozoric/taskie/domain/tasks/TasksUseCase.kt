package hr.ferit.brunozoric.taskie.domain.tasks

import hr.ferit.brunozoric.taskie.common.ErrorLambda
import hr.ferit.brunozoric.taskie.common.SuccessLambda
import hr.ferit.brunozoric.taskie.model.response.GetTasksResponse


interface TasksUseCase{
    fun execute(onSuccess: SuccessLambda<GetTasksResponse>, onFailure:ErrorLambda)
}