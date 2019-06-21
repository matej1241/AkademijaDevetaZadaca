package hr.ferit.brunozoric.taskie.presentation

import hr.ferit.brunozoric.taskie.common.RESPONSE_OK
import hr.ferit.brunozoric.taskie.domain.register.RegisterUseCase
import hr.ferit.brunozoric.taskie.model.request.UserDataRequest
import hr.ferit.brunozoric.taskie.model.response.RegisterResponse
import hr.ferit.brunozoric.taskie.networking.interactors.TaskieInteractor
import hr.ferit.brunozoric.taskie.ui.register.RegisterContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(private val registerUseCase: RegisterUseCase): RegisterContract.Presenter{

    private lateinit var view: RegisterContract.View

    override fun setView(view: RegisterContract.View) {
        this.view = view
    }

    override fun onRegisterClicked(user: UserDataRequest) {
        registerUseCase.execute(user, ::handleOkResponse, ::handleSomethingWentWrong)
    }

    private fun handleOkResponse(registerResponse: RegisterResponse?) {
        view.onRegisterSuccesfull()
    }

    private fun handleSomethingWentWrong(error:Throwable) {
        view.onRegisterFailed()
    }
}