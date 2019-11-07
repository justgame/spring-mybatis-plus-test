package com.github.justgame.mybatisplus;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMybatisPlusTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisPlusTestApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> System.out.println("hello");
    }
}
