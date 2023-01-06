package com.work.on.upload.service.domain.ports.output.repository;

import com.work.on.upload.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);

    Optional<Customer> findCustomerByName(String name);

    Customer createCustomer(Customer customer);
}
