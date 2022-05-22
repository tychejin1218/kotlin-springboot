package com.example.todo.model.http

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.validation.Validation

class TodoDtoTest {

  val validator = Validation.buildDefaultValidatorFactory().validator

  @Test
  fun todoDtoTest() {

    val todoDto = TodoDto().apply {
      this.title = "테스트 일정"
      this.description = "테스트"
      this.schedule = "2022-05-22 17:00:00"
    }

    val result = validator.validate(todoDto)
    Assertions.assertEquals(true, result.isEmpty())
  }
}