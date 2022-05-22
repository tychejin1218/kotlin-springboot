package com.example.todo.repository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl(
  val todoDataBase: TodoDataBase
) : TodoRespository {

  override fun save(todo: Todo): Todo {
    return todo.index?.let { index ->
      // update
      findOne(index)?.apply {
        this.title = todo.title
        this.description = todo.description
        this.schedule = todo.schedule
        this.updateAt = LocalDateTime.now()
      }
    } ?: kotlin.run {
      // insert
      todo.apply {
        this.index = ++todoDataBase.index
        this.createAt = LocalDateTime.now()
        this.updateAt = LocalDateTime.now()
      }.run {
        todoDataBase.todoList.add(todo)
        this
      }
    }
  }

  override fun saveAll(todoList: MutableList<Todo>): Boolean {
    return try {
      todoList.forEach {
        save(it)
      }
      true
    } catch (e: Exception) {
      false
    }
  }

  override fun delete(index: Int): Boolean {
    return findOne(index)?.let {
      todoDataBase.todoList.remove(it)
      true
    } ?: kotlin.run {
      false
    }
  }

  override fun findOne(index: Int): Todo {
    return todoDataBase.todoList.first { it.index == index }
  }

  override fun findAll(): MutableList<Todo> {
    return todoDataBase.todoList
  }
}