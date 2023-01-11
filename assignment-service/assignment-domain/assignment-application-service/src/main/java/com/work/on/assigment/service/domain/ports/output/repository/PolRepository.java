package com.work.on.assigment.service.domain.ports.output.repository;

import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.valueobject.PollId;

import java.util.Optional;


public interface PolRepository {

    Poll createPoll(Poll poll);

    Optional<Poll> findPollById(PollId pollId);
}
