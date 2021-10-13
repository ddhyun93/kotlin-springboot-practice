package com.example.todo.database

data class TodoDataBase(
    var index: Int = 0,
    var todoList: MutableList<Todo> = mutableListOf()
) {
    // 초기화
    fun init(){
        this.todoList = mutableListOf()
        println("[DEBUG] todo database init")
    }
}