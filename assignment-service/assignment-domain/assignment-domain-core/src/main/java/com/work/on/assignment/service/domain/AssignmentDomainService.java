package com.work.on.assignment.service.domain;

import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;

public interface AssignmentDomainService {
    AssignmentCreatedEvent createAssignment (Assignment assignment,int deliveryDays);
}
