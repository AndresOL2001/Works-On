package com.work.on.assignment.service.domain.event;

import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.entity.Question;

import java.time.ZonedDateTime;

public class QuestionCreatedEvent {
    private final Question question;

    private final ZonedDateTime createdAt;

    public QuestionCreatedEvent(Question question, ZonedDateTime createdAt) {
        this.question = question;
        this.createdAt = createdAt;
    }

    public Question getQuestion() {
        return question;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
