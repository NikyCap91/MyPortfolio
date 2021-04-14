package com.myportfolio.api.modelApi

data class LoginResponse(
    var isPassCodeEnabled : Boolean,
    var locale : String,
    var redirectUrl : String,
    var sessionId : String,
    var status : Int,
    var statusText : String
)
