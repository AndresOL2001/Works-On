package com.work.on.upload.service.domain.event;

import com.work.on.domain.event.DomainEvent;
import com.work.on.upload.service.domain.entity.File;

import java.time.ZonedDateTime;

public class LogoCreatedEvent implements DomainEvent<File> {

    private final File file;
    private final ZonedDateTime createdAt;

    public File getFile() {
        return file;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public LogoCreatedEvent(File file, ZonedDateTime createdAt) {
        this.file = file;
        this.createdAt = createdAt;
    }
}
