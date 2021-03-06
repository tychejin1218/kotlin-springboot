package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.AbstractBindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import java.lang.StringBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class PostApiController {

    @PutMapping("/put-mapping")
    fun postMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(
        @Valid @RequestBody userRequest: UserRequest,
        bindingResult: AbstractBindingResult
    ): ResponseEntity<String> {
        if (bindingResult.hasErrors()) {
            // 500 error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field + " : " + message + "\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.ok("")
        // 1. Response
        /*return UserResponse().apply {
            // 2. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 3. description
            this.description = "~~~~~"
        }.apply {
            // 4. user mutable list
            var userList = mutableListOf<UserRequest>()

            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name = "admin01"
                this.age = 35
                this.email = "admin01@gmail.com"
                this.address = "incheon"
                this.phoneNumber = "010-1234-5678"
            })

            userList.add(UserRequest().apply {
                this.name = "admin02"
                this.age = 35
                this.email = "admin02@gmail.com"
                this.address = "incheon"
                this.phoneNumber = "010-1234-5678"
            })

            this.user = userList
        }*/
    }
}