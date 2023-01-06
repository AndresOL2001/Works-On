package com.work.on.common.dataaccess.customer.exception;

import com.work.on.domain.exception.DomainException;

public class CustomerCommonDataAccessException extends DomainException {
    public CustomerCommonDataAccessException(String message) {
        super(message);
    }

    public CustomerCommonDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
