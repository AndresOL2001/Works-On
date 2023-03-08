package com.work.on.assignment.service.domain;

import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.entity.Question;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;
import com.work.on.assignment.service.domain.event.QuestionCreatedEvent;

public interface QuestionDomainService {

    QuestionCreatedEvent createQuestion (Question question);

}
