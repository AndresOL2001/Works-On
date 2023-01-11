package com.work.on.assignment.service.dataaccess.adapter;

import com.work.on.assigment.service.domain.mapper.AssignmentDataMapper;
import com.work.on.assigment.service.domain.ports.output.repository.CustomerRepository;
import com.work.on.assignment.service.dataaccess.mapper.AssignmentDataAccessMapper;
import com.work.on.assignment.service.dataaccess.repository.CustomerJpaRepository;
import com.work.on.assignment.service.domain.entity.Customer;
import com.work.on.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;

    private final AssignmentDataAccessMapper assignmentDataAccessMapperMapper;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository,  AssignmentDataAccessMapper assignmentDataAccessMapperMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.assignmentDataAccessMapperMapper = assignmentDataAccessMapperMapper;
    }

    @Override
    public Optional<Customer> findAssignment(CustomerId customerId) {
        return customerJpaRepository.findById(customerId).map(assignmentDataAccessMapperMapper::customerEntityToCustomer);
    }

    @Override
    public Customer createCustomer(Customer customer) {

        return assignmentDataAccessMapperMapper.customerEntityToCustomer(customerJpaRepository
                .save(assignmentDataAccessMapperMapper.customerToCustomerEntity(customer)));

    }
}
