package com.eTag.back.config;


import com.eTag.back.entity.BaseResult;
import com.eTag.back.entity.LabelResult;
import com.eTag.back.exception.ELabelException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕捉
 */
@RestControllerAdvice
public class ParamExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handleMethodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        return BaseResult.fail(exception.getMessage());
    }

    @ExceptionHandler(ELabelException.class)
    public LabelResult handleELabelException(ELabelException exception) {
        return LabelResult.builder().State("Done").Message("获取失败:"+ exception.getMessage()).Number("").build();

    }

    /**
     *查询不到用户
     * @param exception
     * @return
     */
    @ExceptionHandler( AuthenticationException.class )
    public BaseResult handleAuthenticationException(AuthenticationException exception) {
        String message = exception.getMessage();
        if (exception instanceof LockedException) {
            message = "账户被锁定，请联系管理员!";
        } else if (exception instanceof CredentialsExpiredException) {
            message = "账户失效，请联系管理员!";
        } else if (exception instanceof AccountExpiredException) {
            message =  "账户过期，请联系管理员!";
        } else if (exception instanceof DisabledException) {
            message =  "账户被禁用，请联系管理员!";
        } else if (exception instanceof BadCredentialsException) {
            message = "用户名或者密码输入错误";
        }
        return BaseResult.fail("登入失败:" + message);
    }


    /**
     * 权限不足
     * @param exception
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public BaseResult handleAccessDeniedException(AccessDeniedException exception) {
        return BaseResult.fail("当前用户权限不足:"+ exception.getMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    public BaseResult handleRuntimeException(RuntimeException exception) {
        return BaseResult.fail(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResult handleException(Exception e) {
        return BaseResult.fail("未知异常:"+e.getMessage());
    }
}