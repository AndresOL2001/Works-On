package com.work.on.assignment.service.domain.event;

import com.work.on.assignment.service.domain.entity.Assignment;

import java.time.ZonedDateTime;

public class AssignmentCreatedEvent {
    private final Assignment assignment;

    private final ZonedDateTime createdAt;

    public AssignmentCreatedEvent(Assignment assignment, ZonedDateTime createdAt) {
        this.assignment = assignment;
        this.createdAt = createdAt;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
