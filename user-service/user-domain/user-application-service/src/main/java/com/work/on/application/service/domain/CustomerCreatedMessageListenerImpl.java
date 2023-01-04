package com.work.on.application.service.domain;

import com.work.on.application.service.domain.dto.message.CustomerModel;
import com.work.on.application.service.domain.mapper.UserDataMapper;
import com.work.on.application.service.domain.ports.input.message.listener.user.CustomerCreatedMessageListener;
import com.work.on.application.service.domain.ports.output.repository.CustomerRepository;
import com.work.on.user.service.domain.entity.Customer;
import com.work.on.user.service.domain.exception.UserDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerCreatedMessageListenerImpl implements CustomerCreatedMessageListener {

    private final CustomerRepository customerRepository;

    private final UserDataMapper userDataMapper;

    public CustomerCreatedMessageListenerImpl(CustomerRepository customerRepository, UserDataMapper userDataMapper) {
        this.customerRepository = customerRepository;
        this.userDataMapper = userDataMapper;
    }


    @Override
    public void customerCreated(CustomerModel customerModel) {
        Customer customer = customerRepository.createCustomer(userDataMapper.customerModelToCustomer(customerModel));
        if (customer == null) {
            log.error("Customer could not be created in order database with id: {}", customer.getId());
            throw new UserDomainException("Customer could not be created in order database with id " +
                    customer.getId());
        }
        log.info("Customer is created in order database with id: {}", customer.getId());
    }
}
