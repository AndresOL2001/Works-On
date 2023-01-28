package com.work.on.assignment.service.domain;

import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.event.PollCreatedEvent;

public interface PollDomainService {

    PollCreatedEvent createPoll (Poll poll);


}
