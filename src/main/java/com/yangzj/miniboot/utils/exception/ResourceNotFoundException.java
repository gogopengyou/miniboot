package com.yangzj.miniboot.utils.exception;

import java.util.Map;

/**
 * description:自定义资源未找到异常
 *
 * @author yangzj
 * @date 2020/03/25
 */
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}