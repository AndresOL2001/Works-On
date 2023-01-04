package com.work.on.user.service.dataaccess.user.exception;

public class UserDataaccessException extends RuntimeException {

    public UserDataaccessException(String message) {
        super(message);
    }

    public UserDataaccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
