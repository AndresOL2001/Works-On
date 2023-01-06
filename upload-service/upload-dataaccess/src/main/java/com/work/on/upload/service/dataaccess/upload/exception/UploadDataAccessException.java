package com.work.on.upload.service.dataaccess.upload.exception;

import com.work.on.domain.exception.DomainException;

public class UploadDataAccessException extends DomainException {
    public UploadDataAccessException(String message) {
        super(message);
    }

    public UploadDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
