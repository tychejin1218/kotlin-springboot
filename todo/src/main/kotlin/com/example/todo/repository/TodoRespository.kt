package com.example.todo.repository

import com.example.todo.database.Todo

interface TodoRespository {

  fun save(todo: Todo): Todo

  fun saveAll(todoList: MutableList<Todo>): Boolean

  fun delete(index: Int): Boolean

  fun findOne(index:Int) : Todo

  fun findAll(): MutableList<Todo>
}