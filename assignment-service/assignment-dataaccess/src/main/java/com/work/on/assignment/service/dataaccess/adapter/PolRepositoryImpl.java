package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.ports.output.repository.PolRepository;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.PollJpaRepository;
import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.valueobject.PollId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PolRepositoryImpl implements PolRepository {

    private final PollJpaRepository polRepository;

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    public PolRepositoryImpl(PollJpaRepository polRepository, AssignmentDataAccessMapper assignmentDataAccessMapper) {
        this.polRepository = polRepository;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
    }

    @Override
    public Poll createPoll(Poll poll) {
        return assignmentDataAccessMapper.polEntityToPol(polRepository.save(assignmentDataAccessMapper.polToPolEntity(poll)));
    }

    @Override
    public Optional<Poll> findPollById(PollId pollId) {
        return polRepository.findById(pollId).map(assignmentDataAccessMapper::polEntityToPol);
    }
}
