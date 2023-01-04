package com.work.on.application.service.domain.ports.input.service;


import com.work.on.application.service.domain.dto.create.CreateUserCommand;
import com.work.on.application.service.domain.dto.create.CreateUserResponse;
import com.work.on.application.service.domain.dto.track.GetUserQuery;
import com.work.on.application.service.domain.dto.track.GetUserResponse;
import com.work.on.application.service.domain.dto.track.GetUsersResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface UserApplicationService {

    CreateUserResponse createUser(@Valid List<CreateUserCommand> createUserCommand);

    GetUserResponse getUser(@Valid GetUserQuery getUserQuery);

    GetUsersResponse getUserByCountryAndStateAndZone(String country, String state, String zone);

    GetUserResponse getUserByControlNumber(@Valid UUID uuid);

}
