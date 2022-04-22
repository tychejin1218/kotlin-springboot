package com.example.mvc.model.http

data class UserRequest(
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var address: String? = null,
    //var phone-number: String? = null : 변수 선언 시 하이픈을 사용할 수 없음
    var phoneNumber: String? = null
)
