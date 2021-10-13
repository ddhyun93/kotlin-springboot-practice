package com.example.todo.config

import com.example.todo.database.TodoDataBase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration          // 어플리케이션이 구동될때 참조하는 곳
class AppConfig {

    @Bean(initMethod = "init")              // 스프링부트가 실행될때 빈이 작동하며 TodoDataBase의 init 메소드를 실행시킴
    fun todoDataBase(): TodoDataBase {
        return TodoDataBase()
    }
}