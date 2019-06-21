package hr.ferit.brunozoric.taskie.presentation

import hr.ferit.brunozoric.taskie.common.RESPONSE_OK
import hr.ferit.brunozoric.taskie.domain.login.LoginUseCase
import hr.ferit.brunozoric.taskie.model.request.UserDataRequest
import hr.ferit.brunozoric.taskie.model.response.LoginResponse
import hr.ferit.brunozoric.taskie.networking.interactors.TaskieInteractor
import hr.ferit.brunozoric.taskie.prefs.SharedPrefsHelper
import hr.ferit.brunozoric.taskie.prefs.provideSharedPrefs
import hr.ferit.brunozoric.taskie.ui.login.LoginContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(private val loginUseCase: LoginUseCase) :
    LoginContract.Presenter {

    private lateinit var view: LoginContract.View
    private val prefs = provideSharedPrefs()
    override fun setView(view: LoginContract.View) {
        this.view = view
    }

    override fun onUserLogin(user: UserDataRequest) {
        loginUseCase.execute(user, ::handleOkResponse, ::handleSomethingWentWrong)
    }


    private fun handleOkResponse(loginResponse: LoginResponse?) {
        loginResponse?.token?.let { prefs.storeUserToken(it) }
        view.onLoginSuccesfull()
    }

    private fun handleSomethingWentWrong(error: Throwable) {
        view.onLoginFailed()
    }
}