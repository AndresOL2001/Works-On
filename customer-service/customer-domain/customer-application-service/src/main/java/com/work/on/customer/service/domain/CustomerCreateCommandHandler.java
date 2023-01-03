package com.work.on.customer.service.domain;

import com.work.on.customer.service.domain.dto.create.CreateCustomerCommand;
import com.work.on.customer.service.domain.entity.Customer;
import com.work.on.customer.service.domain.event.CustomerCreatedEvent;
import com.work.on.customer.service.domain.exception.CustomerDomainException;
import com.work.on.customer.service.domain.mapper.CustomerDataMapper;
import com.work.on.customer.service.domain.ports.output.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CustomerCreateCommandHandler {
    private final CustomerDomainService customerDomainService;

    private final CustomerRepository customerRepository;

    private final CustomerDataMapper customerDataMapper;

    public CustomerCreateCommandHandler(CustomerDomainService customerDomainService, CustomerRepository customerRepository, CustomerDataMapper customerDataMapper) {
        this.customerDomainService = customerDomainService;
        this.customerRepository = customerRepository;
        this.customerDataMapper = customerDataMapper;
    }

    @Transactional
    public CustomerCreatedEvent createCustomer(CreateCustomerCommand createCustomerCommand) {
        Customer customer = customerDataMapper.createCustomerCommandToCustomer(createCustomerCommand);
        CustomerCreatedEvent customerCreatedEvent = customerDomainService.createCustomerCreatedEvent(customer);
        Customer savedCustomer = customerRepository.createCustomer(customer);
        if (savedCustomer == null) {
            log.error("Could not save customer with id: {}", customerCreatedEvent.getCustomer().getId());
            throw new CustomerDomainException("Could not save customer with id " +
                    customerCreatedEvent.getCustomer().getId());
        }
        log.info("Returning CustomerCreatedEvent for customer id: {}", customerCreatedEvent.getCustomer().getId());
        return customerCreatedEvent;
    }
}
