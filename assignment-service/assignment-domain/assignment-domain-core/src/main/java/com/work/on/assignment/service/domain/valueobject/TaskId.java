package com.work.on.assignment.service.domain.valueobject;

import com.work.on.domain.valueobject.BaseId;

import java.util.UUID;

public class TaskId extends BaseId<UUID> {
    public TaskId(UUID value) {
        super(value);
    }
}
