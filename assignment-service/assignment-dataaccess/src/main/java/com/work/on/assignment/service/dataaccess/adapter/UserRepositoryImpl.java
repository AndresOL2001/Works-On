package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.ports.output.repository.UserRepository;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.UserJpaRepository;
import com.work.on.assignment.service.domain.entity.User;
import com.work.on.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, AssignmentDataAccessMapper assignmentDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
    }

    @Override
    public Optional<User> findUser(UserId userId) {

        return userJpaRepository.findById(new UserId(userId.getValue())).map(assignmentDataAccessMapper :: userEntityToUser);
    }

    @Override
    public User createUser(User user) {

        return assignmentDataAccessMapper.userEntityToUser(userJpaRepository.save(assignmentDataAccessMapper.userToUserEntity(user)));
    }
}
