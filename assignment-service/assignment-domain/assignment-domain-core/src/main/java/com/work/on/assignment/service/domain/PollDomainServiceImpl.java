package com.work.on.assignment.service.domain;

import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.event.AssignmentCreatedEvent;
import com.work.on.assignment.service.domain.event.PollCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class PollDomainServiceImpl implements PollDomainService{
    @Override
    public PollCreatedEvent createPoll(Poll poll) {
        poll.initiatePoll(poll.getTaskId());
        log.info("Poll created with id: {} is initiated", poll.getId().getValue());
        return new PollCreatedEvent(poll, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
