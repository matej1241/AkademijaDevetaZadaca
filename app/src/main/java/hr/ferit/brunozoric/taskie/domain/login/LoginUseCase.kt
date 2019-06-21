package hr.ferit.brunozoric.taskie.domain.login

import hr.ferit.brunozoric.taskie.common.ErrorLambda
import hr.ferit.brunozoric.taskie.common.SuccessLambda
import hr.ferit.brunozoric.taskie.model.request.UserDataRequest
import hr.ferit.brunozoric.taskie.model.response.LoginResponse

interface LoginUseCase {
    fun execute(body: UserDataRequest, onSuccess: SuccessLambda<LoginResponse>, onFailure: ErrorLambda)
}
