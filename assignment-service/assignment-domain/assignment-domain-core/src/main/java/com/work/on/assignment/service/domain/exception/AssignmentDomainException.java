package com.work.on.assignment.service.domain.exception;

import com.work.on.domain.exception.DomainException;

public class AssignmentDomainException extends DomainException {
    public AssignmentDomainException(String message) {
        super(message);
    }

    public AssignmentDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
