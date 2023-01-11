package com.work.on.assigment.service.domain.ports.output.repository;

import com.work.on.assignment.service.domain.entity.Customer;
import com.work.on.assignment.service.domain.entity.User;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.UserId;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findUser(UserId userId);

    User createUser(User user);
}
