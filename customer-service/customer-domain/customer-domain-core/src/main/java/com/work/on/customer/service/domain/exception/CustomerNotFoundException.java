package com.work.on.customer.service.domain.exception;

import com.work.on.domain.exception.DomainException;

public class CustomerNotFoundException extends DomainException {
    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
