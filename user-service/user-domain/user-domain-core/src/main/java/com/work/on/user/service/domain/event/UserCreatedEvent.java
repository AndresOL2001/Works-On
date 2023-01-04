package com.work.on.user.service.domain.event;

import com.work.on.domain.event.DomainEvent;
import com.work.on.user.service.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.List;

public class UserCreatedEvent implements DomainEvent<List<User>> {
    public List<User> getUser() {
        return user;
    }

    private final List<User> user;
    private final ZonedDateTime createdAt;

    public UserCreatedEvent(List<User> user, ZonedDateTime createdAt) {
        this.user = user;
        this.createdAt = createdAt;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
