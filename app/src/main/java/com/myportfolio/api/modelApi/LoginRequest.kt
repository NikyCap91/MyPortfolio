package com.myportfolio.api.modelApi

data class LoginRequest(
    var isPassCodeReset : Boolean = false,
    var isRedirectToMobile : Boolean = false,
    var password : String = "",
    var username : String = "",
    var oneTimePassword : String = "",
    var queryParams : Map<String,String> = mapOf("reason" to "session_expired")
)
