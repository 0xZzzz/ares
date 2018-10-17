package com.ares.common.exception;

/**
 * 业务异常
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}
