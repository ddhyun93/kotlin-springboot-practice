package com.example.todo.model.http

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.validation.FieldError
import javax.validation.Validation

class TodoDtoTest {
    val validator = Validation.buildDefaultValidatorFactory().validator // validator 가져오기

    @Test
    fun todoDtoTest(){
        val todoDto = TodoDto().apply {
            this.title = "테스트"
            this.description = ""
            this.schedule = "2020-10-20 13:00:00"
        }
        val result = validator.validate(todoDto)
        result.forEach {
            println(it.propertyPath.last().name)
            println(it.message)
            println(it.invalidValue)
        }
        result.isEmpty()    // 에러가 있는경우 isEmpty > false <> 에러가 없는경우 IsEmpty > true
        Assertions.assertEquals(true, result.isEmpty())
    }
}