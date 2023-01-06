package com.work.on.customer.service.dataaccess.mapper;

import com.work.on.customer.service.dataaccess.entity.ColorEntity;
import com.work.on.customer.service.dataaccess.entity.CustomerEntity;
import com.work.on.customer.service.domain.entity.Color;
import com.work.on.customer.service.domain.entity.Customer;
import com.work.on.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return Customer.builder()
                .id(new CustomerId(customerEntity.getCustomerId()))
                .name(customerEntity.getName())
                .subscriptionType(customerEntity.getSubscriptionType())
                .colorList(customerEntity.getColors().stream().map(colorEntity ->
                                 Color.newBuilder()
                                         .id(colorEntity.getColorId())
                                         .hex(colorEntity.getHexadecimal())
                                         .build())
                        .collect(Collectors.toList()))
                .createdAt(customerEntity.getCreatedAt())
                .name(customerEntity.getName())
                .logo(customerEntity.getLogo())
                .subscriptionFinishAt(customerEntity.getSubscriptionFinishAt())
                .build();
    }

    public CustomerEntity customerToCustomerEntity(Customer customer) {
        return CustomerEntity.builder()
                .customerId(customer.getId().getValue())
                .colors(customer.getColorList().stream().map(color ->
                        ColorEntity.builder()
                                .hexadecimal(color.getHex())
                                .colorId(color.getId())
                                .build()).collect(Collectors.toList()))
                .subscriptionType(customer.getSubscriptionType())
                .createdAt(customer.getCreatedAt())
                .subscriptionFinishAt(customer.getSubscriptionFinishAt())
                .logo(customer.getLogo())
                .name(customer.getName())
                .build();
    }

}
