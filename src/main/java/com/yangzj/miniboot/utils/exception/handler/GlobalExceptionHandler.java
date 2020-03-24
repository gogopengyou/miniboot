package com.yangzj.miniboot.utils.exception.handler;

import com.yangzj.miniboot.utils.exception.BaseException;
import com.yangzj.miniboot.utils.exception.ErrorReponse;
import com.yangzj.miniboot.utils.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/25
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 也可以将 BaseException 换为 RuntimeException
     * @param ex 系统全局异常
     * @param request 请求域对象
     * @return 系统响应
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleAppException(BaseException ex, HttpServletRequest request) {
        ErrorReponse representation = new ErrorReponse(ex, request.getRequestURI());
        return new ResponseEntity<>(representation, new HttpHeaders(), ex.getError().getStatus());
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorReponse> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        ErrorReponse errorReponse = new ErrorReponse(ex, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorReponse);
    }
}