package com.work.on.assigment.service.domain;

import com.work.on.assigment.service.domain.dto.query.GetAssignmentQuery;
import com.work.on.assigment.service.domain.dto.response.GetAssignmentResponse;
import com.work.on.assigment.service.domain.mapper.AssignmentDataMapper;
import com.work.on.assigment.service.domain.ports.output.repository.AssignmentRepository;
import com.work.on.assignment.service.domain.AssignmentDomainService;
import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.exception.AssignmentDomainException;
import com.work.on.domain.valueobject.AssignmentId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Component
public class GetAssignmentQueryHandler {
    public GetAssignmentQueryHandler( AssignmentRepository assignmentRepository, AssignmentDataMapper assignmentDataMapper) {
        this.assignmentRepository = assignmentRepository;
        this.assignmentDataMapper = assignmentDataMapper;
    }


    private final AssignmentRepository assignmentRepository;

    private final AssignmentDataMapper assignmentDataMapper;


    @Transactional(readOnly = true)
    public GetAssignmentResponse getAssignment(GetAssignmentQuery getAssignmentQuery) {
        Optional<Assignment> assignmentOptional =
                assignmentRepository.findAssignment(new AssignmentId(getAssignmentQuery.getAssignmentId().getValue()));
        if (assignmentOptional.isEmpty()) {
            log.warn("Could not find any assignment with assignment id: {}", getAssignmentQuery.getAssignmentId().getValue());
            throw new AssignmentDomainException("Could not find assignment with assignment id: " +
                    getAssignmentQuery.getAssignmentId().getValue());
        }
        return assignmentDataMapper.assignmentToGetAssignmentResponse(assignmentOptional.get(),new ArrayList<>());
    }
}
