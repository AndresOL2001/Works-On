package com.work.on.assignment.service.domain;

import com.work.on.assignment.service.domain.entity.Question;
import com.work.on.assignment.service.domain.event.QuestionCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class QuestionDomainServiceImpl implements QuestionDomainService{
    @Override
    public QuestionCreatedEvent createQuestion(Question question) {
        question.initiatePoll();
        return new QuestionCreatedEvent(question, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
