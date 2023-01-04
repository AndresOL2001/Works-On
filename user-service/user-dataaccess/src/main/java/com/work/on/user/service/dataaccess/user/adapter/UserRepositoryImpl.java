package com.work.on.user.service.dataaccess.user.adapter;

import com.work.on.application.service.domain.ports.output.repository.UserRepository;
import com.work.on.user.service.dataaccess.user.entity.UserEntity;
import com.work.on.user.service.dataaccess.user.mapper.UserDataaccessMapper;
import com.work.on.user.service.dataaccess.user.repository.UserJpaRepository;
import com.work.on.user.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    private final UserDataaccessMapper userDataaccessMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserDataaccessMapper userDataaccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDataaccessMapper = userDataaccessMapper;
    }

    @Override
    public Optional<User> findUser(UUID userId) {
        return Optional.of(userDataaccessMapper.UserEntityToUser(userJpaRepository.findById(userId).get()));
    }

    @Override
    public List<User> createUsers(List<User> users) {
        List<UserEntity> usersToSave = userDataaccessMapper.usersToUsersEntity(users);
        return userDataaccessMapper.usersEntitiesToUsers(userJpaRepository.saveAll(usersToSave));
    }

    @Override
    public Optional<User> findByControlNumber(UUID controlNumber) {
        return Optional.of(userDataaccessMapper.UserEntityToUser(userJpaRepository.findByControlNumber(controlNumber).get()));
    }

    @Override
    public Optional<List<User>> findByCountryAndStateAndZone(String country, String state, String zone) {
        List<UserEntity> users = userJpaRepository.findByCountryAndStateAndZone(country,state,zone).get();
        return Optional.of(userDataaccessMapper.usersEntitiesToUsers(users));
    }
}
