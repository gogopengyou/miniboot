package com.yangzj.miniboot.utils.exception;

import org.springframework.http.HttpStatus;

/**
 * description: 标识异常的错误码
 *
 * @author yangzj
 * @date 2020/03/25
 */

public enum ErrorCode {

    /**
     * 未找到资源异常
     */
    RESOURCE_NOT_FOUND(1001, HttpStatus.NOT_FOUND, "未找到该资源"),

    /**
     * 服务器内部异常
     */
    INTERNAL_SERVER_ERROR(1000, HttpStatus.INTERNAL_SERVER_ERROR, "服务器内部发生异常"),


    /**
     * 格式验证失败异常
     */
    REQUEST_VALIDATION_FAILED(1002, HttpStatus.BAD_REQUEST, "请求数据格式验证失败");

    private final int code;

    private final HttpStatus status;

    private final String message;

    ErrorCode(int code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}

