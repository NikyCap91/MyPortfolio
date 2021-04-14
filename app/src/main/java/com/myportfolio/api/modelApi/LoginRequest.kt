package com.myportfolio.api.modelApi

data class LoginRequest(
    var isPassCodeReset : Boolean = false,
    var isRedirectToMobile : Boolean = false,
    var password : String = "Gaia641491",
    var username : String = "niccolocapitelli",
    var oneTimePassword : String = "",
    var queryParams : Map<String,String> = mapOf("reason" to "session_expired")
)
