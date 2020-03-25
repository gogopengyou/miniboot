package com.yangzj.miniboot.utils.exception;

import java.util.Map;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/25
 */
public class InternalServerException extends BaseException {

    public InternalServerException(Map<String, Object> data) {
        super(ErrorCode.INTERNAL_SERVER_ERROR, data);
    }
}