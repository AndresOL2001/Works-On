package com.work.on.assignment.service.domain.event;

import com.work.on.assignment.service.domain.entity.Poll;

import java.time.ZonedDateTime;

public class PollCreatedEvent {

    private final Poll poll;

    private final ZonedDateTime createdAt;

    public PollCreatedEvent(Poll poll, ZonedDateTime createdAt) {
        this.poll = poll;
        this.createdAt = createdAt;
    }

    public Poll getPoll() {
        return poll;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
