package com.work.on.customer.service.domain;

import com.work.on.customer.service.domain.entity.Customer;
import com.work.on.customer.service.domain.event.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class CustomerDomainServiceImpl implements CustomerDomainService{

    @Override
    public CustomerCreatedEvent createCustomerCreatedEvent(Customer customer) {
        customer.initiateCustomer();
        customer.validateSubscriptionFinishAt(customer);
        log.info("Customer created with id: {} is initiated", customer.getId().getValue());
        return new CustomerCreatedEvent(customer, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
