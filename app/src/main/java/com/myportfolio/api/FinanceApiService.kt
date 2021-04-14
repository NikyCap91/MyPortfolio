package com.myportfolio.api

import com.myportfolio.api.modelApi.LoginRequest
import com.myportfolio.api.modelApi.LoginResponse

object FinanceApiService : BaseApiService() {

    private val service : FinanceApi = FinanceApiBuilder.create()

    suspend fun login(username : String, password : String) : Result<LoginResponse> {
        return getResult { service.login(LoginRequest(username = username, password = password)) }
    }
}