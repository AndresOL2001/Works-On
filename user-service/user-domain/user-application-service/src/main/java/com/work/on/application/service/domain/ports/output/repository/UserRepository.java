package com.work.on.application.service.domain.ports.output.repository;

import com.work.on.user.service.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> findUser(UUID userId);

    List<User> createUsers(List<User> users);

    Optional<User> findByControlNumber(String controlNumber);

    Optional<List<User>> findByCountryAndStateAndZone(String country,String state,String zone);
}
