package com.work.on.assigment.service.domain.ports.output.repository;

import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.domain.valueobject.AssignmentId;

import java.util.Optional;
import java.util.UUID;

public interface AssignmentRepository {

    Optional<Assignment> findAssignment(AssignmentId assignmentId);

    Assignment createAssignment(Assignment customer);
}
