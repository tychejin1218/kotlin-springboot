package com.example.mvc.model.http

import com.example.mvc.annotation.StringFormatDateTime
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest(

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String? = null,

    @field:PositiveOrZero // 0 < 숫자를 검증 0도 포함(양수)
    var age: Int? = null,

    @field:Email    // email 양식
    var email: String? = null,

    @field:NotBlank // 공백을 검증
    var address: String? = null,

    //var phone-number: String? = null : 변수 선언 시 하이픈을 사용할 수 없음
    //@JsonProperty("phone_number")
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")
    var phoneNumber: String? = null,

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt: String? = null // yyyy-MM-dd HH:mm:ss ex) 2022-04-08 13:00:00
) {
    /*@AssertTrue(message = "생성일자의 패턴은 yyyy-mm-dd HH:mm:ss 여야 합니다")
    private fun isValidCreateAt():Boolean { // 정상 true, 비정상 false
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch (e: Exception) {
            false
        }
    }*/
}
