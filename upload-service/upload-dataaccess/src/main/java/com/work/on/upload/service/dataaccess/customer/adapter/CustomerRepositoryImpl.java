package com.work.on.upload.service.dataaccess.customer.adapter;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.upload.service.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.work.on.upload.service.dataaccess.customer.repository.CustomerJpaRepository;
import com.work.on.upload.service.domain.entity.Customer;
import com.work.on.upload.service.domain.ports.output.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerDataAccessMapper customerDataAccessMapper;

    private final CustomerJpaRepository customerJpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository, CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository
                .findById(new CustomerId(customerId))
                .map(customerDataAccessMapper::customerEntityToCustomer);
    }

    @Override
    public Optional<Customer> findCustomerByName(String name) {
        return customerJpaRepository
                .findByName(name)
                .map(customerDataAccessMapper::customerEntityToCustomer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDataAccessMapper
                .customerEntityToCustomer(customerJpaRepository
                        .save(customerDataAccessMapper.customerToCustomerEntity(customer)));

    }
}
