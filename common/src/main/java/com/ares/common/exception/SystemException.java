package com.ares.common.exception;

/**
 * 业务异常
 *
 * @author 0xZzzz
 * @date 2018/10/16
 */
public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
