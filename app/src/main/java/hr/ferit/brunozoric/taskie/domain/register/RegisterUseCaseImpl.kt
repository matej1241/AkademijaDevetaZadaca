package hr.ferit.brunozoric.taskie.domain.register

import hr.ferit.brunozoric.taskie.common.ErrorLambda
import hr.ferit.brunozoric.taskie.common.SuccessLambda
import hr.ferit.brunozoric.taskie.model.request.UserDataRequest
import hr.ferit.brunozoric.taskie.model.response.RegisterResponse
import hr.ferit.brunozoric.taskie.persistence.register.RegisterRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterUseCaseImpl(private val registerRepository: RegisterRepository): RegisterUseCase {
    override fun execute(body: UserDataRequest, onSuccess: SuccessLambda<RegisterResponse>, onFailure: ErrorLambda) {
        registerRepository.registerUser(body).enqueue(object : Callback<RegisterResponse> {
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                onFailure(t)
            }
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) response.body()?.run(onSuccess)
                response.errorBody()?.run { onFailure(IllegalStateException("Something went wrong")) }
            }
        })
    }
}