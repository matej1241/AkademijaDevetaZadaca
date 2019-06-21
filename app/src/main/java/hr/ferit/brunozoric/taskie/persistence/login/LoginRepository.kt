package hr.ferit.brunozoric.taskie.persistence.login

import hr.ferit.brunozoric.taskie.model.request.UserDataRequest
import hr.ferit.brunozoric.taskie.model.response.LoginResponse
import retrofit2.Call

interface LoginRepository {
    fun loginUser(body: UserDataRequest): Call<LoginResponse>
}