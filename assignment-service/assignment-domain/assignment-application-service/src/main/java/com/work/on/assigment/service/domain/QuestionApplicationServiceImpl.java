package com.work.on.assigment.service.domain;

import com.work.on.assigment.service.domain.dto.create.CreateQuestionCommand;
import com.work.on.assigment.service.domain.dto.query.GetQuestionQuery;
import com.work.on.assigment.service.domain.dto.response.CreateQuestionResponse;
import com.work.on.assigment.service.domain.mapper.AssignmentDataMapper;
import com.work.on.assigment.service.domain.ports.input.service.QuestionApplicationService;
import com.work.on.assignment.service.domain.event.QuestionCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class QuestionApplicationServiceImpl implements QuestionApplicationService {

    private final CreateQuestionCommandHandler createQuestionCommandHandler;

    private final AssignmentDataMapper assignmentDataMapper;

    public QuestionApplicationServiceImpl(CreateQuestionCommandHandler createQuestionCommandHandler, AssignmentDataMapper assignmentDataMapper) {
        this.createQuestionCommandHandler = createQuestionCommandHandler;
        this.assignmentDataMapper = assignmentDataMapper;
    }

    @Override
    public CreateQuestionResponse createQuestion(CreateQuestionCommand createQuestionCommand) {

        QuestionCreatedEvent questionCreatedEvent = createQuestionCommandHandler.createQuestion(createQuestionCommand);
        // customerMessagePublisher.publish(customerCreatedEvent);
        return assignmentDataMapper
                .questionCreatedEventToQuestionResponse(questionCreatedEvent,"Question created successfully");
    }

    @Override
    public GetQuestionQuery trackOrder(GetQuestionQuery getQuestionQuery) {
        return null;
    }
}
