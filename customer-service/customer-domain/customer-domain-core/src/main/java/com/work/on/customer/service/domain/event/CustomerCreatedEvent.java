package com.work.on.customer.service.domain.event;

import com.work.on.customer.service.domain.entity.Customer;
import com.work.on.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public  class CustomerCreatedEvent implements DomainEvent<Customer> {

    private final Customer customer;
    private final ZonedDateTime createdAt;

    public CustomerCreatedEvent(Customer customer, ZonedDateTime createdAt) {
        this.customer = customer;
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
