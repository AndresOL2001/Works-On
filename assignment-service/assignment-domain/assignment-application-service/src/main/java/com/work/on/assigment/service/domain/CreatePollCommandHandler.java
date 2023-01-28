package com.work.on.assigment.service.domain;

import com.work.on.assigment.service.domain.dto.create.CreatePollCommand;
import com.work.on.assigment.service.domain.mapper.AssignmentDataMapper;
import com.work.on.assigment.service.domain.ports.output.repository.PolRepository;
import com.work.on.assignment.service.domain.PollDomainService;
import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.event.PollCreatedEvent;
import com.work.on.assignment.service.domain.exception.AssignmentDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CreatePollCommandHandler {

    private final PollDomainService pollDomainService;

    private final PolRepository polRepository;

    private final AssignmentDataMapper assignmentDataMapper;

    public CreatePollCommandHandler(PollDomainService pollDomainService, PolRepository polRepository, AssignmentDataMapper assignmentDataMapper) {
        this.pollDomainService = pollDomainService;
        this.polRepository = polRepository;
        this.assignmentDataMapper = assignmentDataMapper;
    }
    @Transactional
    public PollCreatedEvent createPoll(CreatePollCommand createPollCommand) {
        Poll poll = assignmentDataMapper.createPollCommandToPoll(createPollCommand);
        PollCreatedEvent pollCreatedEvent = pollDomainService.createPoll(poll);//domainService

        Poll pollDatabase = polRepository.createPoll(poll);

        if (pollDatabase == null) {
            log.error("Could not save poll with id: {}", pollCreatedEvent.getPoll().getId());
            throw new AssignmentDomainException("Could not save customer with id " +
                    pollCreatedEvent.getPoll().getId());
        }
        log.info("Returning PollCreatedEvent for task id: {} with {} number of tasks", pollCreatedEvent.getPoll().getTaskId()
                ,2);
        return pollCreatedEvent;
    }
}
