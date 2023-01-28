package com.work.on.assigment.service.domain.ports.input.service;

import com.work.on.assigment.service.domain.dto.create.CreatePollCommand;
import com.work.on.assigment.service.domain.dto.query.GetPollQuery;
import com.work.on.assigment.service.domain.dto.response.CreatePollResponse;
import com.work.on.assigment.service.domain.dto.response.GetPollResponse;

import javax.validation.Valid;

public interface IPollApplicationService {

    CreatePollResponse createPoll(@Valid CreatePollCommand createPollCommand);

    GetPollResponse getPoll(@Valid GetPollQuery getPollQuery);
}
