package com.work.on.user.service.dataaccess.customer.adapter;

import com.work.on.application.service.domain.ports.output.repository.CustomerRepository;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.user.service.dataaccess.customer.entity.CustomerEntity;
import com.work.on.user.service.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.work.on.user.service.dataaccess.customer.repository.CustomerJpaRepository;
import com.work.on.user.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository, CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(new CustomerId(customerId)).map(customerDataAccessMapper::customerEntityToCustomer);
    }

    @Override
    public Optional<Customer> findCustomerByName(String name) {
        return customerJpaRepository.findByName(name).map(customerDataAccessMapper::customerEntityToCustomer);
    }


    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = customerDataAccessMapper.customerToCustomerEntity(customer);
        return customerDataAccessMapper.customerEntityToCustomer(customerJpaRepository.save(customerEntity));

    }
}
