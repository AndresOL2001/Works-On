package com.work.on.application.service.domain;

import com.work.on.application.service.domain.dto.create.CreateUserCommand;
import com.work.on.application.service.domain.dto.create.CreateUserResponse;
import com.work.on.application.service.domain.dto.track.GetUserQuery;
import com.work.on.application.service.domain.dto.track.GetUserResponse;
import com.work.on.application.service.domain.dto.track.GetUsersResponse;
import com.work.on.application.service.domain.mapper.UserDataMapper;
import com.work.on.application.service.domain.ports.input.service.UserApplicationService;
import com.work.on.application.service.domain.ports.output.message.publisher.user.UserMessagePublisher;
import com.work.on.user.service.domain.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserCreateCommandHandler userCreateCommandHandler;

    private final GetUserQueryHandler getUserQueryHandler;

    private final UserDataMapper customerDataMapper;

    public UserApplicationServiceImpl(UserCreateCommandHandler userCreateCommandHandler, GetUserQueryHandler getUserQueryHandler, UserDataMapper customerDataMapper) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.getUserQueryHandler = getUserQueryHandler;
        this.customerDataMapper = customerDataMapper;
    }

    @Override
    public CreateUserResponse createUser(List<CreateUserCommand> createUserCommand) {
        userCreateCommandHandler.createUser(createUserCommand);
        return customerDataMapper
                .createUserCommandToCreateUserResponse(
                        "User saved successfully!");
    }

    @Override
    public GetUserResponse getUser(GetUserQuery getUserQuery) {

        return getUserQueryHandler.getUser(getUserQuery);

    }

    @Override
    public GetUsersResponse getUserByCountryAndStateAndZone(String country, String state, String zone) {
        return getUserQueryHandler.getUserByCountryAndStateAndZone(country, state, zone);
    }

    @Override
    public GetUserResponse getUserByControlNumber(UUID uuid) {
        return getUserQueryHandler.getUserByControlNumber(uuid);
    }
}
