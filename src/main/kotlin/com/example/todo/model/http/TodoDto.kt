package com.example.todo.model.http

import com.example.todo.annotation.StringFormatDateTime
import com.example.todo.database.Todo
import io.swagger.annotations.ApiModelProperty
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank


data class TodoDto(
    @field:ApiModelProperty(
        value = "DB INDEX",
        example = "1",
        required = false
    )
    var index: Int?=null,

    @field:ApiModelProperty(
        value = "일정명",
        example = "밥먹기",
        required = true
    )
    @field:NotBlank
    var title: String?=null,

    @field:ApiModelProperty(
        value = "일정설명",
        example = "단백질 많이",
        required = false
    )
    var description: String?=null,

    @field:ApiModelProperty(
        value = "시간",
        example = "2020-01-01 00:00:00",
        required = true
    )
    @field:NotBlank
    @field:StringFormatDateTime
    // yyyy-MM-dd HH:mm:ss
    var schedule: String?=null,

    var createdAt: LocalDateTime?=null,
    var updatedAt: LocalDateTime?=null
) {
//    // TODO custom annotation 사용
//    @AssertTrue(message = "Not yyyy-MM-dd HH:mm:ss format")
//    fun validSchedule(): Boolean {
//        return try {
//            LocalDateTime.parse(schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
}

fun TodoDto.convertTodoDto(todo: Todo): TodoDto {
    return TodoDto().apply {
        this.index = todo.index
        this.title = todo.title
        this.description = todo.description
        this.schedule = todo.schedule?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.createdAt = todo.createdAt
        this.updatedAt = todo.updatedAt
    }
}