package com.yakun.exception;

public class ServiceException extends BaseException {
    public ServiceException(Integer code, String message) {
        super(code, message);
    }
}
