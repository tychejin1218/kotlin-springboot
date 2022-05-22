package com.example.todo.controller.api.todo

import com.example.todo.model.http.TodoDto
import com.example.todo.service.TodoService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Tag(name = "일정관리", description = "일정관리 API")
@RestController
@RequestMapping("/api/todo")
class TodoApiController(
  val todoService: TodoService
) {

  // R
  @Operation(summary = "일정확인", description = "일정확인 API")
  @GetMapping(path = [""])
  fun read(@RequestParam(required = false) index: Int?): ResponseEntity<Any?> {
    return index?.let {
      todoService.read(it)
    }?.let {
      return ResponseEntity.ok(it)
    } ?: kotlin.run {
      return ResponseEntity
        .status(HttpStatus.MOVED_PERMANENTLY)
        .header(HttpHeaders.LOCATION, "/api/todo/all")
        .build()
    }
  }

  @GetMapping(path = ["/all"])
  fun readAll(): MutableList<TodoDto> {
    return todoService.readAll()
  }

  // C
  @PostMapping(path = [""]) // create = 201, update = 200
  fun create(@Valid @RequestBody todoDto: TodoDto): TodoDto? {
    return todoService.create(todoDto)
  }

  // U
  @PutMapping(path = [""])
  fun update(@Valid @RequestBody todoDto: TodoDto): TodoDto? {
    return todoService.create(todoDto)
  }

  // D
  @DeleteMapping(path = ["/{index}"])
  fun delete(@PathVariable(name = "index") _index: Int): ResponseEntity<Any> {
    if (!todoService.delete(_index)) {
      return ResponseEntity.status(500).build()
    }
    return ResponseEntity.ok().build()
  }
}