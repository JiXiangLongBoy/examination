package com.qfedu.examination.common;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*没有权限跳到指定路径*/
@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(AuthorizationException.class)
    public String authorizationException(AuthorizationException ex){
        return "noPermission";
    }
}
