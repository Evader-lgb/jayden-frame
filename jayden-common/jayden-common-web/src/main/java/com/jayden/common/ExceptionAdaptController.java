package com.jayden.common;

import com.jayden.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdaptController {

    @ExceptionHandler(RuntimeException.class)
    public Result runtimeException(RuntimeException e) {
        System.out.println("RuntimeException");
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        System.out.println("Exception");
        return Result.error(e.getMessage());
    }
}
