package com.eTag.back.config;


import com.eTag.back.entity.BaseResult;
import com.eTag.back.entity.LabelResult;
import com.eTag.back.exception.ELabelException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        return BaseResult.fail("用户名密码验证错误");
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
        return BaseResult.fail("运行异常:"+exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResult handleException(Exception e) {
        return BaseResult.fail("未知异常:"+e.getMessage());
    }
}