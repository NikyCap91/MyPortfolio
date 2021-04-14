package com.myportfolio.api

import com.myportfolio.api.modelApi.LoginRequest
import com.myportfolio.api.modelApi.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FinanceApi {

    @POST("/login/secure/login")
    fun login(
        @Body loginRequest: LoginRequest
    ) : Response<LoginResponse>
}