package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
        @RequestParam(value = "age") _age: Int
    ): String {
        print(_name)
        print(_age)
        return _name + " " + _age
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable(value = "name") _name: String,
        @PathVariable(name = "age") _age: Int
    ): String {
        print(_name)
        print(_age)
        return _name + " " + _age
    }
}