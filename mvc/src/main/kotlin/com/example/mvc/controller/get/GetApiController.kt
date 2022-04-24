package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"])
    fun hello(): String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - get method"
    }

    @GetMapping("/get-mapping/path-variable-01/{name}")
    fun pathVariable01(
        @PathVariable name: String
    ): String {
        println(name)
        return name
    }

    @GetMapping("/get-mapping/path-variable-02/{name}/{age}")
    fun pathVariable02(
        @PathVariable name: String,
        @PathVariable age: Int
    ): String {
        println("${name}, ${age}")
        return name + " " + age
    }

    @GetMapping("/get-mapping/path-variable-03/{name}/{age}")
    fun pathVariable03(
        @PathVariable(value = "name") _name: String,
        @PathVariable(name = "age") age: Int
    ): String {
        var name = "kotlin"

        println("${_name}, ${age}")
        return _name + " " + age
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam(name = "name") name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("${name}, ${age}")
        return name + " " + age
    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(
        userRequest: UserRequest
    ): UserRequest {
        println(userRequest)
        return userRequest;
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParam(
        @RequestParam map: Map<String, Any>
    ): Map<String, Any> {
        println(map)
        var phoneNumber = map.get("phone-number")
        println(phoneNumber)
        return map
    }
}