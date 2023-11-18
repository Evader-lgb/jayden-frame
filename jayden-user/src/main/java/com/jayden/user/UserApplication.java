package com.jayden.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.jayden.*.mapper")
@ComponentScan("com.jayden")
public class UserApplication {
    public static void main(String[] args) {
        // 集成log4j2异步日志
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(UserApplication.class);
    }
}
