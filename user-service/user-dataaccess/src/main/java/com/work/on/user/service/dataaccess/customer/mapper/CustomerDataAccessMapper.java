package com.work.on.user.service.dataaccess.customer.mapper;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.user.service.dataaccess.customer.entity.CustomerEntity;
import com.work.on.user.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {
    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return Customer
                .newBuilder()
                .name(customerEntity.getName())
                .id(new CustomerId(customerEntity.getCustomerId()))
                .build();
    }

    public CustomerEntity customerToCustomerEntity(Customer customer) {
        return CustomerEntity
                .builder()
                .name(customer.getName())
                .customerId(customer.getId().getValue())
                .build();
    }
}
