package com.work.on.assigment.service.domain.ports.output.publisher;

import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;

public interface AssignmentMessagePublisher {
    void publish(AssignmentCreatedEvent assignmentCreatedEvent);
}
