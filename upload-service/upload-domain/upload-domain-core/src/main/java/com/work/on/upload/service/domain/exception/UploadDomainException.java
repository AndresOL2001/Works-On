package com.work.on.upload.service.domain.exception;

public class UploadDomainException extends RuntimeException{
    public UploadDomainException(String message) {
        super(message);
    }

    public UploadDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
