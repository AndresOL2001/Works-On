package com.work.on.user.service.domain;

import com.work.on.user.service.domain.entity.User;
import com.work.on.user.service.domain.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class UserDomainServiceImpl implements UserDomainService{
    @Override
    public UserCreatedEvent createUserCreatedEvent(List<User> users) {
        users.forEach(User::initiateUser);
        log.info("Users created with a size of: {} are initiated", users.size());
        return new UserCreatedEvent(users, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
