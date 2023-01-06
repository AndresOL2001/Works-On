package com.work.on.application.service.domain.mapper;

import com.work.on.application.service.domain.dto.create.CreateUserCommand;
import com.work.on.application.service.domain.dto.create.CreateUserResponse;
import com.work.on.application.service.domain.dto.message.CustomerMessagingModel;
import com.work.on.application.service.domain.dto.track.GetUserResponse;
import com.work.on.application.service.domain.dto.track.GetUsersResponse;
import com.work.on.application.service.domain.dto.track.UserResponse;
import com.work.on.application.service.domain.dto.track.UsersResponse;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.user.service.domain.entity.Customer;
import com.work.on.user.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserDataMapper {

    public List<User> createUserCommandToUsers(List<CreateUserCommand> createUserCommand) {
        return createUserCommand.stream().map(createUserCommandDTO ->
                User.newBuilder()
                        .controlNumber(createUserCommandDTO.getControlNumber())
                        .name(createUserCommandDTO.getName())
                        .address(createUserCommandDTO.getAddress())
                        .email(createUserCommandDTO.getEmail())
                        .country(createUserCommandDTO.getCountry())
                        .zone(createUserCommandDTO.getZone())
                        .job(createUserCommandDTO.getJob())
                        .state(createUserCommandDTO.getState())
                        .customerId(createUserCommandDTO.getCustomerId())
                        .build()
                ).collect(Collectors.toList());
    }
    public GetUserResponse createUserResponse(UserResponse user, String message) {
        return new GetUserResponse(user, message);
    }

    public GetUsersResponse createUsersResponse(List<UsersResponse> user, String message) {
        return new GetUsersResponse(user, message);
    }

    public CreateUserResponse createUserCommandToCreateUserResponse(String message){
        return CreateUserResponse.builder().message(message).build();
    }

    public Customer customerModelToCustomer(CustomerMessagingModel customerModel) {
        return Customer.newBuilder()
                .name(customerModel.getName())
                .id(new CustomerId(UUID.fromString(customerModel.getCustomerId())))
                .build();
    }

    public UserResponse userToUserResponse(User user,String customerName) {
        return UserResponse.builder()
                .points(user.getPoints())
                .country(user.getCountry())
                .job(user.getJob())
                .name(user.getName())
                .state(user.getState())
                .zone(user.getZone())
                .address(user.getAddress())
                .customerName(customerName)
                .email(user.getEmail())
                .build();
    }


    public List<UsersResponse> usersToUsersResponse(List<User> users) {
        return users.stream().map(user ->
                        UsersResponse.builder()
                        .country(user.getCountry())
                        .points(user.getPoints())
                        .job(user.getJob())
                        .name(user.getName())
                        .state(user.getState())
                        .zone(user.getZone())
                        .address(user.getAddress())
                        .email(user.getEmail())
                                .customerId(user.getCustomerId().toString())
                        .build()
                ).collect(Collectors.toList());
    }
}
