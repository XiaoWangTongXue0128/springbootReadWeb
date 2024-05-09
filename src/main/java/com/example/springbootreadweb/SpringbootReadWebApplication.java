package com.example.springbootreadweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootreadweb.mapper")
public class SpringbootReadWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReadWebApplication.class, args);
    }

}
