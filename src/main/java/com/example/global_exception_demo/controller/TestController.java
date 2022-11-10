package com.example.global_exception_demo.controller;

import com.example.global_exception_demo.exception.OtherException;
import com.example.global_exception_demo.exception.ParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test1")
    public String test1(@RequestParam("id") int id) {
        System.out.printf("TestController test1(): id = %s\n", id);
        if (id <= 0) {
            //controller 抛出异常
            throw new ParameterException("invalid id");
        } else {
            return "ok";
        }
    }

    @RequestMapping("/test2")
    public String test2() {
        System.out.println("TestController test2()");
        throw new OtherException();
    }

    @RequestMapping("/test3")
    public String test3() {
        System.out.println("TestController test3()");
        //抛出其他未知的异常
        throw new RuntimeException();
    }
}
