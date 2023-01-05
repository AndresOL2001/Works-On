package com.work.on.user.service.dataaccess.user.mapper;

import com.work.on.domain.valueobject.Money;
import com.work.on.domain.valueobject.UserId;
import com.work.on.user.service.dataaccess.customer.entity.CustomerEntity;
import com.work.on.user.service.dataaccess.user.entity.UserEntity;
import com.work.on.user.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserDataaccessMapper {

    public User UserEntityToUser (UserEntity userEntity){
        return User.newBuilder()
                .id(new UserId(UUID.fromString(userEntity.getUserId().toString())))
                .zone(userEntity.getZone())
                .job(userEntity.getJob())
                .name(userEntity.getName())
                .state(userEntity.getState())
                .country(userEntity.getCountry())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .address(userEntity.getAddress())
                .controlNumber(userEntity.getControlNumber())
                .customerId(userEntity.getCustomer().getCustomerId())
                .points(new Money(userEntity.getPoints()))
                .build();
    }

    public List<UserEntity> usersToUsersEntity(List<User> users) {
        return users.stream().map(user ->
                UserEntity.builder()
                        .userId(user.getId().getValue())
                        .job(user.getJob())
                        .email(user.getEmail())
                        .state(user.getState())
                        .address(user.getAddress())
                        .password(user.getPassword())
                        .zone(user.getZone())
                        .points(user.getPoints().getAmount())
                        .controlNumber(user.getControlNumber())
                        .country(user.getCountry())
                        .name(user.getName())
                        .customer(new CustomerEntity(user.getCustomerId()))
                        .build()
                ).collect(Collectors.toList());
    }

    public List<User> usersEntitiesToUsers(List<UserEntity> userEntities) {
        return userEntities.stream().map(user ->
                User.newBuilder()
                        .id(new UserId(UUID.fromString(user.getUserId().toString())))
                        .job(user.getJob())
                        .email(user.getEmail())
                        .state(user.getState())
                        .address(user.getAddress())
                        .password(user.getPassword())
                        .zone(user.getZone())
                        .points(new Money(user.getPoints()))
                        .controlNumber(user.getControlNumber())
                        .country(user.getCountry())
                        .customerId(user.getCustomer().getCustomerId())
                        .name(user.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
