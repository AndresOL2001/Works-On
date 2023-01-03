package com.work.on.customer.service.domain.ports.output.repository;

import com.work.on.customer.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);

    Customer createCustomer(Customer customer);


}
