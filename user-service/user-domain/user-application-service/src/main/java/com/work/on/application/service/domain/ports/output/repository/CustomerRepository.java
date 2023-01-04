package com.work.on.application.service.domain.ports.output.repository;

import com.work.on.user.service.domain.entity.Customer;
import com.work.on.user.service.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);

    Customer createCustomer(Customer customer);
}
