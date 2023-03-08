package com.work.on.assigment.service.domain;

import com.work.on.assigment.service.domain.dto.create.CreatePollCommand;
import com.work.on.assigment.service.domain.dto.create.CreateQuestionCommand;
import com.work.on.assigment.service.domain.mapper.AssignmentDataMapper;
import com.work.on.assigment.service.domain.ports.output.repository.PolRepository;
import com.work.on.assigment.service.domain.ports.output.repository.QuestionRepository;
import com.work.on.assignment.service.domain.PollDomainService;
import com.work.on.assignment.service.domain.QuestionDomainService;
import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.entity.Question;
import com.work.on.assignment.service.domain.event.PollCreatedEvent;
import com.work.on.assignment.service.domain.event.QuestionCreatedEvent;
import com.work.on.assignment.service.domain.exception.AssignmentDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CreateQuestionCommandHandler {
    private final QuestionDomainService questionDomainService;

    private final QuestionRepository questionRepository;

    private final AssignmentDataMapper assignmentDataMapper;

    public CreateQuestionCommandHandler(QuestionDomainService questionDomainService, QuestionRepository questionRepository, AssignmentDataMapper assignmentDataMapper) {
        this.questionDomainService = questionDomainService;
        this.questionRepository = questionRepository;
        this.assignmentDataMapper = assignmentDataMapper;
    }

    @Transactional
    public QuestionCreatedEvent createQuestion(CreateQuestionCommand createQuestionCommand) {
        Question question = assignmentDataMapper.createQuestionCommandToQuestion(createQuestionCommand);
        QuestionCreatedEvent questionCreatedEvent = questionDomainService.createQuestion(question);//domainService

        Question questionDatabase = questionRepository.createQuestion(question);

        if (questionDatabase == null) {
            log.error("Could not save question with Poll id: {}", questionCreatedEvent.getQuestion().getPollId());
            throw new AssignmentDomainException("Could not save customer with id " +
                    questionCreatedEvent.getQuestion().getPollId());
        }
        log.info("Returning QuestionCreatedEvent for poll id: {} ", questionCreatedEvent.getQuestion().getPollId());
        return questionCreatedEvent;
    }
}
