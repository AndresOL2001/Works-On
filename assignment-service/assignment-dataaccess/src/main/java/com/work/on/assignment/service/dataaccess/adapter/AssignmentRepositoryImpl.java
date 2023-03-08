package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.ports.output.repository.AssignmentRepository;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.AssignmentJpaRepository;
import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.domain.valueobject.AssignmentId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AssignmentRepositoryImpl implements AssignmentRepository {

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    private final AssignmentJpaRepository assignmentJpaRepository;

    public AssignmentRepositoryImpl(AssignmentDataAccessMapper assignmentDataAccessMapper, AssignmentJpaRepository assignmentJpaRepository) {
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
        this.assignmentJpaRepository = assignmentJpaRepository;
    }

    @Override
    public Optional<Assignment> findAssignment(AssignmentId assignmentId) {
            //Find assignment
        return assignmentJpaRepository.findById(assignmentId)
                .map(assignmentDataAccessMapper :: assignmentEntityToAssignment);
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {

        return assignmentDataAccessMapper.assignmentEntityToAssignment(
                assignmentJpaRepository.save(assignmentDataAccessMapper.assignmentToAssignmentEntity(assignment)));
    }
}
