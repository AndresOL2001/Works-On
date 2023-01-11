package com.work.on.assignment.service.dataaccess.exception;

import com.work.on.domain.exception.DomainException;

public class AssignmentDataAccessException extends DomainException {
    public AssignmentDataAccessException(String message) {
        super(message);
    }

    public AssignmentDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
