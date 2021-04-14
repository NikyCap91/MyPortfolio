package com.myportfolio.model

import com.myportfolio.api.FinanceApi
import com.myportfolio.api.FinanceApiBuilder
import com.myportfolio.api.modelApi.LoginRequest
import com.myportfolio.api.modelApi.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SessionManager {

    private val service : FinanceApi = FinanceApiBuilder.create()

    init
    {
        login()
    }

    private fun login(){

        service.login(LoginRequest()).enqueue(object : Callback<LoginResponse> {

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                val resp = response.body()
            }
        })
    }
}