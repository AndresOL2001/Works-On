package com.work.on.assignment.service.domain.valueobject;

import com.work.on.domain.valueobject.BaseId;

import java.util.UUID;

public class QuestionId extends BaseId<UUID> {
    public QuestionId(UUID value) {
        super(value);
    }
}
