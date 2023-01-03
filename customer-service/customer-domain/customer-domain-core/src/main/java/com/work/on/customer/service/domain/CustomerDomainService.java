package com.work.on.customer.service.domain;

import com.work.on.customer.service.domain.entity.Customer;
import com.work.on.customer.service.domain.event.CustomerCreatedEvent;

import java.time.ZonedDateTime;

public interface CustomerDomainService{

     CustomerCreatedEvent createCustomerCreatedEvent(Customer customer);

}
