package com.work.on.assigment.service.domain.ports.output.repository;

import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.assignment.service.domain.entity.Customer;
import com.work.on.domain.valueobject.AssignmentId;
import com.work.on.domain.valueobject.CustomerId;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findAssignment(CustomerId customerId);

    Customer createCustomer(Customer customer);
}
