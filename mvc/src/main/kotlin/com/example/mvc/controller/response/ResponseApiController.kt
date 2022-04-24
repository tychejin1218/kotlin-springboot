package com.example.mvc.controller.response

import com.example.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx
    // GET http:localhost:8080/api/response
    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        return age?.let {

            if (age < 20) {
                return ResponseEntity.status(400).body("aget 값은 20보다 커야 합니다.")
            }

            ResponseEntity.status(200).body("ok")

        }?: kotlin.run{
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        /*
        // 1. age == null -> 400 error
        if (age == null) {
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        // 1. age < 20 -> 400 error
        if (age < 20) {
            return ResponseEntity.status(400).body("aget 값은 20보다 커야 합니다.")
        }


        println(age)
        return ResponseEntity.status(200).body("ok")
        */
    }

    // 2. post 200
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest) // object mapper -> object -> json
    }

    // 3. put 201
    @PutMapping("")
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // 1. 기존 데이터가 없어서 새로 생성했다.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id:Int): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
}