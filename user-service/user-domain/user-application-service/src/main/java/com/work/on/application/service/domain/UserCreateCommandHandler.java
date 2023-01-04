package com.work.on.application.service.domain;

import com.work.on.application.service.domain.dto.create.CreateUserCommand;
import com.work.on.application.service.domain.mapper.UserDataMapper;
import com.work.on.application.service.domain.ports.output.repository.CustomerRepository;
import com.work.on.application.service.domain.ports.output.repository.UserRepository;
import com.work.on.user.service.domain.UserDomainService;
import com.work.on.user.service.domain.entity.Customer;
import com.work.on.user.service.domain.entity.User;
import com.work.on.user.service.domain.event.UserCreatedEvent;
import com.work.on.user.service.domain.exception.UserDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserCreateCommandHandler {

    private final UserDomainService userDomainService;

    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;

    private final UserDataMapper customerDataMapper;

    public UserCreateCommandHandler(UserDomainService userDomainService, UserRepository userRepository, CustomerRepository customerRepository, UserDataMapper customerDataMapper) {
        this.userDomainService = userDomainService;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.customerDataMapper = customerDataMapper;
    }

    @Transactional
    public UserCreatedEvent createUser(List<CreateUserCommand> createUserCommandList) {
        List<User> users = customerDataMapper.createUserCommandToUsers(createUserCommandList);

        for (User user: users) {
            Optional<Customer> customerOptional =customerRepository.findCustomer(user.getCustomerId());
            if (customerOptional.isEmpty()) {
                log.warn("Could not find customer with customer id: {}", user.getId().getValue());
                throw new UserDomainException("Could not find customer with customer id: " +
                        user.getId().getValue());
            }
        }

        UserCreatedEvent userCreatedEvent = userDomainService.createUserCreatedEvent(users);
        List<User> savedCustomer = userRepository.createUsers(users);
        if (savedCustomer == null) {
            log.error("Could not save users with size: {}", userCreatedEvent.getUser().size());
            throw new UserDomainException("Could not save customer with size: {} " +
                    userCreatedEvent.getUser().size());
        }
        log.info("Returning UserCreatedEvent with size: {}", userCreatedEvent.getUser().size());
        return userCreatedEvent;
    }
}
