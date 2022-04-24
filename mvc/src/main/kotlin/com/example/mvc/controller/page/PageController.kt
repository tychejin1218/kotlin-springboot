package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test01")
    fun response01(): String {
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test02")
    fun response02(): UserRequest {
        return UserRequest().apply {
            this.name = "amdin"
        }
    }
}