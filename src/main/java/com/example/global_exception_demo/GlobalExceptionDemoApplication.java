package com.example.global_exception_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlobalExceptionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalExceptionDemoApplication.class, args);
        System.out.println("======== GlobalExceptionDemoApplication run ========");
    }

}
