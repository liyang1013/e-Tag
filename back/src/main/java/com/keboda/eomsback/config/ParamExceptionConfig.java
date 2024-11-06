package com.keboda.eomsback.config;


import com.keboda.eomsback.entity.BaseResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕捉
 */
@RestControllerAdvice
public class ParamExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        return BaseResult.fail(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResult handleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return BaseResult.fail("运行异常:"+e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResult handleException(Exception e) {
        e.printStackTrace();
        return BaseResult.fail("未知异常:"+e.getMessage());
    }
}