package com.work.on.assigment.service.domain;

import com.work.on.assigment.service.domain.dto.create.CreateAssignmentCommand;
import com.work.on.assigment.service.domain.dto.query.GetAssignmentQuery;
import com.work.on.assigment.service.domain.dto.response.CreateAssignmentResponse;
import com.work.on.assigment.service.domain.dto.response.GetAssignmentResponse;
import com.work.on.assigment.service.domain.mapper.AssignmentDataMapper;
import com.work.on.assigment.service.domain.ports.input.service.AssignmentApplicationService;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Validated
@Service
public class AssignmentApplicationServiceImpl implements AssignmentApplicationService {

    private final CreateAssignmentCommandHandler createAssignmentCommandHandler;

    private final GetAssignmentQueryHandler getAssignmentQueryHandler;

    private final AssignmentDataMapper assignmentDataMapper;

    public AssignmentApplicationServiceImpl(CreateAssignmentCommandHandler createAssignmentCommandHandler, GetAssignmentQueryHandler getAssignmentQueryHandler, AssignmentDataMapper assignmentDataMapper) {
        this.createAssignmentCommandHandler = createAssignmentCommandHandler;
        this.getAssignmentQueryHandler = getAssignmentQueryHandler;
        this.assignmentDataMapper = assignmentDataMapper;
    }


    @Override
    public CreateAssignmentResponse createCustomer(CreateAssignmentCommand createAssignmentCommand) {

        AssignmentCreatedEvent assignmentCreatedEvent = createAssignmentCommandHandler.createCustomer(createAssignmentCommand);
       // customerMessagePublisher.publish(customerCreatedEvent);
        return assignmentDataMapper
                .assignmentToCreateAssignmentResponse(assignmentCreatedEvent.getAssignment(),
                        "Customer saved successfully!");
    }

    @Override
    public GetAssignmentResponse trackOrder(GetAssignmentQuery assignmentId) {

        return getAssignmentQueryHandler.getAssignment(assignmentId);
    }
}
