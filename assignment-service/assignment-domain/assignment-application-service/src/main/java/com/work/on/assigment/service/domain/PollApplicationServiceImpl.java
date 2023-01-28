package com.work.on.assigment.service.domain;

import com.work.on.assigment.service.domain.dto.create.CreatePollCommand;
import com.work.on.assigment.service.domain.dto.query.GetPollQuery;
import com.work.on.assigment.service.domain.dto.response.CreatePollResponse;
import com.work.on.assigment.service.domain.dto.response.GetPollResponse;
import com.work.on.assigment.service.domain.mapper.AssignmentDataMapper;
import com.work.on.assigment.service.domain.ports.input.service.IPollApplicationService;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;
import com.work.on.assignment.service.domain.event.PollCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PollApplicationServiceImpl implements IPollApplicationService {

    private final CreatePollCommandHandler createPollCommandHandler;

    public PollApplicationServiceImpl(CreatePollCommandHandler createPollCommandHandler, AssignmentDataMapper assignmentDataMapper) {
        this.createPollCommandHandler = createPollCommandHandler;
        this.assignmentDataMapper = assignmentDataMapper;
    }

    private final AssignmentDataMapper assignmentDataMapper;

    @Override
    public CreatePollResponse createPoll(CreatePollCommand createPollCommand) {
        PollCreatedEvent pollCreatedEvent = createPollCommandHandler.createPoll(createPollCommand);
        // customerMessagePublisher.publish(customerCreatedEvent);
        return assignmentDataMapper
                .pollCreatedEventToCreatePollResponse(pollCreatedEvent,
                        "Poll created successfully!");
    }

    @Override
    public GetPollResponse getPoll(GetPollQuery getPollQuery) {
        return null;
    }
}
