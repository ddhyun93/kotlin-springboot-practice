package com.example.todo.controller.api.todo

import com.example.todo.model.http.TodoDto
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController {
    // R
    @GetMapping("")
    fun read(@RequestParam(required = false) index:Int?){}

    // C
    @PostMapping("")
    fun create(@Valid @RequestBody todoDto: TodoDto){

    }

    // U
    @PutMapping("")
    fun update(@Valid @RequestBody todoDto: TodoDto){

    }

    // D
    @DeleteMapping("/{index}")
    fun delete(@PathVariable(name="index") _index: Int){

    }

}