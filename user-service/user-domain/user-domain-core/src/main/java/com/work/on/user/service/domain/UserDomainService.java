package com.work.on.user.service.domain;

import com.work.on.user.service.domain.entity.User;
import com.work.on.user.service.domain.event.UserCreatedEvent;

import java.util.List;

public interface UserDomainService {
    UserCreatedEvent createUserCreatedEvent(List<User> users);

}
