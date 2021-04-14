package com.myportfolio.api

import retrofit2.Response

abstract class BaseApiService {

    protected suspend fun <T> getResult(call : suspend () -> Response<T>) : Result<T> {
        try {
            val response = call()

            if(response.isSuccessful){
                val body = response.body()
                if(body != null){
                    return Result.Success(body)
                }
            }

            return error("${response.code()}:${response.message()}")
        }
        catch(e: Exception)
        {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String) : Result<T>{
        return Result.Error("Network call has failed for a following reason: $message")
    }
}

sealed class Result<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T) : Result<T>(data)
    class Loading<T>(data: T? = null) : Result<T>(data)
    class Error<T>(message: String, data: T? = null) : Result<T>(data,message)
}