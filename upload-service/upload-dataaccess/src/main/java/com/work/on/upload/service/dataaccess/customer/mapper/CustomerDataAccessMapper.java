package com.work.on.upload.service.dataaccess.customer.mapper;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.upload.service.dataaccess.customer.entity.CustomerEntity;
import com.work.on.upload.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {
    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {

        return Customer.newBuilder()
                .id(new CustomerId(customerEntity.getCustomerId()))
                .name(customerEntity.getName())
                .build();
    }

    public CustomerEntity customerToCustomerEntity(Customer customer){
        return CustomerEntity.builder()
                .customerId(customer.getId().getValue())
                .name(customer.getName())
                .build();
    }
}
