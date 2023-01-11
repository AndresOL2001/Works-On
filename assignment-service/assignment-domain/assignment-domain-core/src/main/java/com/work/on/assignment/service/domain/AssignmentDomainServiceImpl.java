package com.work.on.assignment.service.domain;

import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class AssignmentDomainServiceImpl implements AssignmentDomainService{
    @Override
    public AssignmentCreatedEvent createAssignment(Assignment assignment,int deliveryDays) {
        assignment.getTasks().stream().forEach(task -> task.initializeTask(assignment.getId(),task));
        assignment.initiateAssignment(deliveryDays);
        log.info("Assignment created with id: {} is initiated", assignment.getId().getValue());
        return new AssignmentCreatedEvent(assignment, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
