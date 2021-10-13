package com.example.todo.model.http

import com.example.todo.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank


data class TodoDto(
    var index: Int?=null,

    @field:NotBlank
    var title: String?=null,

    var description: String?=null,

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