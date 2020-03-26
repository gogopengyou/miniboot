package com.yangzj.miniboot.utils.exception.handler;

import com.google.common.collect.ImmutableMap;
import com.yangzj.miniboot.utils.exception.BaseException;
import com.yangzj.miniboot.utils.exception.ErrorReponse;
import com.yangzj.miniboot.utils.exception.InternalServerException;
import com.yangzj.miniboot.utils.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * description: 自定义异常处理类
 * 非自定义异常可考虑走errorPage（404.html 500.html ...）[页面形式返回]
 * 也可考虑走全局runtime exception handler.[json形式返回]
 * @author yangzj
 * @date 2020/03/25
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * throw new BaseException((ErrorCode.xxx, requestData)) 时触发。
     * @param ex 系统全局 自定义 异常
     * @param request 请求域对象
     * @return 系统响应
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleAppException(BaseException ex, HttpServletRequest request) {
        ErrorReponse representation = new ErrorReponse(ex, request.getRequestURI());
        return new ResponseEntity<>(representation, new HttpHeaders(), ex.getError().getStatus());
    }

    /*@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleGlobalException(RuntimeException rex, HttpServletRequest request) {
        BaseException ex = new InternalServerException(ImmutableMap.of(rex.toString(), rex.getMessage()));
        ErrorReponse representation = new ErrorReponse(ex, request.getRequestURI());
        return new ResponseEntity<>(representation, new HttpHeaders(), ex.getError().getStatus());
    }*/

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorReponse> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        ErrorReponse errorReponse = new ErrorReponse(ex, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorReponse);
    }
}