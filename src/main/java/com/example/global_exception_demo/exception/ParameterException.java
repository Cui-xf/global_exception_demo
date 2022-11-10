package com.example.global_exception_demo.exception;

/**
 * 参数异常
 */
public class ParameterException extends RuntimeException {
    public ParameterException(String message) {
        super(message);
    }
}
