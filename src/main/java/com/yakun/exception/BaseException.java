package com.yakun.exception;

public class BaseException extends RuntimeException {
    public BaseException(Integer code, String message) {
        super(message);

    }
}
