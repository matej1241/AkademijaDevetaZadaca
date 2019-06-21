package hr.ferit.brunozoric.taskie.domain.register

import hr.ferit.brunozoric.taskie.common.ErrorLambda
import hr.ferit.brunozoric.taskie.common.SuccessLambda
import hr.ferit.brunozoric.taskie.model.request.UserDataRequest
import hr.ferit.brunozoric.taskie.model.response.RegisterResponse


interface RegisterUseCase{
    fun execute(body: UserDataRequest, onSuccess: SuccessLambda<RegisterResponse>, onFailure: ErrorLambda)
}