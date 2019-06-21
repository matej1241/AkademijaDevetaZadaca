package hr.ferit.brunozoric.taskie.persistence.register

import hr.ferit.brunozoric.taskie.model.request.UserDataRequest
import hr.ferit.brunozoric.taskie.model.response.RegisterResponse
import retrofit2.Call

interface RegisterRepository {
    fun registerUser(body: UserDataRequest): Call<RegisterResponse>
}