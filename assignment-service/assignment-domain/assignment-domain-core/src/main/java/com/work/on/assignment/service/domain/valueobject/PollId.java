package com.work.on.assignment.service.domain.valueobject;

import com.work.on.domain.valueobject.BaseId;

import java.util.UUID;

public class PollId extends BaseId<UUID> {
    public PollId(UUID value) {
        super(value);
    }
}
