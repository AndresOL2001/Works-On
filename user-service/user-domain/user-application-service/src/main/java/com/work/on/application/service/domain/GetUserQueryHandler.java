package com.work.on.application.service.domain;

import com.work.on.application.service.domain.dto.track.GetUserQuery;
import com.work.on.application.service.domain.dto.track.GetUserResponse;
import com.work.on.application.service.domain.dto.track.GetUsersResponse;
import com.work.on.application.service.domain.mapper.UserDataMapper;
import com.work.on.application.service.domain.ports.output.repository.CustomerRepository;
import com.work.on.application.service.domain.ports.output.repository.UserRepository;
import com.work.on.user.service.domain.entity.User;
import com.work.on.user.service.domain.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class GetUserQueryHandler {
    private final UserDataMapper userDataMapper;

    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;

    public GetUserQueryHandler(UserDataMapper userDataMapper, UserRepository userRepository, CustomerRepository customerRepository) {
        this.userDataMapper = userDataMapper;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public GetUserResponse getUser(GetUserQuery trackOrderQuery) {
        Optional<User> userResult =
                userRepository.findUser(trackOrderQuery.getUserId());
        if (userResult.isEmpty()) {
            log.warn("Could not find user with tracking id: {}", trackOrderQuery.getUserId());
            throw new UserNotFoundException("Could not find user with tracking id: " +
                    trackOrderQuery.getUserId());
        }

        String customerName = customerRepository.findCustomer(userResult.get().getCustomerId()).get().getName();

        return userDataMapper.createUserResponse(userDataMapper.userToUserResponse(userResult.get(),customerName),"Returning user correctly");
    }

    @Transactional(readOnly = true)
    public GetUserResponse getUserByControlNumber(String uuid) {
        Optional<User> userResult =
                userRepository.findByControlNumber(uuid);
        if (userResult.isEmpty()) {
            log.warn("Could not find user with tracking id: {}", uuid);
            throw new UserNotFoundException("Could not find user with tracking id: " +
                    uuid);
        }

        String customerName = customerRepository.findCustomer(userResult.get().getCustomerId()).get().getName();

        return userDataMapper.createUserResponse(userDataMapper.userToUserResponse(userResult.get(),customerName),"Returning user correctly");
    }

    @Transactional(readOnly = true)
    public GetUsersResponse getUserByCountryAndStateAndZone(String country, String state, String zone) {
        Optional<List<User>> userResult = userRepository.findByCountryAndStateAndZone(country,state,zone);
        if (userResult.isEmpty()) {
            log.warn("Could not find any user with country: {} state: {} and zone: {}", country,state,zone);
            throw new UserNotFoundException("Could not find any user with country: "+country +"state: "+ state +" zone: "+zone);
        }

        return userDataMapper.createUsersResponse(userDataMapper.usersToUsersResponse(userResult.get()),"Returning user correctly");
    }
}
