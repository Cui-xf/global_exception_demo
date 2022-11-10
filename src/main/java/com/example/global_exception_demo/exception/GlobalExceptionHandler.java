package com.example.global_exception_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册全局异常处理切面
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //处理 参数异常
    @ExceptionHandler(value = ParameterException.class)
    //返回状态码 400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleParameterException(HttpServletRequest request, ParameterException e) {
        String format = String.format("ParameterException: message = %s, url = %s", e.getMessage(), request.getRequestURI());
        //打印日志
        System.out.println(format);
        //返回结果
        return format;
    }

    //处理其他未知异常，通常作为兜底
    @ExceptionHandler(value = Exception.class)
    //返回状态码 500
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleUnknownException(HttpServletRequest request, Exception e) {
        if (e instanceof OtherException) {
            //可以针对某些类型的异常单独处理
            System.out.print("OtherException");
        } else {
            //未知异常
            System.out.println("Unknown Exception");
        }
        //返回数据
        return "Internal Server Error";
    }
}
