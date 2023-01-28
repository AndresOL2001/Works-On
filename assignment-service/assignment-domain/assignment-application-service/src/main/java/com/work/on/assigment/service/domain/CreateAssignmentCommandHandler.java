package com.work.on.assigment.service.domain;

import com.work.on.assigment.service.domain.dto.create.CreateAssignmentCommand;
import com.work.on.assigment.service.domain.mapper.AssignmentDataMapper;
import com.work.on.assigment.service.domain.ports.output.repository.AssignmentRepository;
import com.work.on.assigment.service.domain.ports.output.repository.TaskRepository;
import com.work.on.assignment.service.domain.AssignmentDomainService;
import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.entity.Task;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;
import com.work.on.assignment.service.domain.exception.AssignmentDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class CreateAssignmentCommandHandler {

    private final AssignmentDomainService assignmentDomainService;

    private final AssignmentRepository assignmentRepository;


    private final AssignmentDataMapper assignmentDataMapper;

    public CreateAssignmentCommandHandler(AssignmentDomainService assignmentDomainService, AssignmentRepository assignmentRepository, AssignmentDataMapper assignmentDataMapper) {
        this.assignmentDomainService = assignmentDomainService;
        this.assignmentRepository = assignmentRepository;
        this.assignmentDataMapper = assignmentDataMapper;
    }

    @Transactional
    public AssignmentCreatedEvent createCustomer(CreateAssignmentCommand createAssignmentCommand) {
        Assignment assignment = assignmentDataMapper.createAssignmentCommandToAssignment(createAssignmentCommand);
        AssignmentCreatedEvent assignmentCreatedEvent = assignmentDomainService.createAssignment(assignment,createAssignmentCommand.getDeliveryDays());

        //List<Task> tasksCreated = taskRepository.createTasks(assignment.getTasks());

        Assignment assignmentDatabase = assignmentRepository.createAssignment(assignment);

        if (assignmentDatabase == null) {
            log.error("Could not save assignment with id: {}", assignmentCreatedEvent.getAssignment().getId());
            throw new AssignmentDomainException("Could not save customer with id " +
                    assignmentCreatedEvent.getAssignment().getId().getValue().toString());
        }
        log.info("Returning AssignmentCreatedEvent for customer id: {} with {} number of tasks", assignmentCreatedEvent.getAssignment().getId()
        ,2);
        return assignmentCreatedEvent;
    }
}
