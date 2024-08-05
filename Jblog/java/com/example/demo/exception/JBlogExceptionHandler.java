package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
//모든 종류의 예외를 처리하기 위한 예외 처리 핸들러
public class JBlogExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String globalExceptionHandler(Exception e) {
        return "<h1>" +e.getMessage() +"</h1>";
    }

}
