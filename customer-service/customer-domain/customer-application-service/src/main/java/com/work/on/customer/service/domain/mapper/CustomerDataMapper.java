package com.work.on.customer.service.domain.mapper;

import com.work.on.customer.service.domain.dto.create.CreateCustomerCommand;
import com.work.on.customer.service.domain.dto.create.CreateCustomerResponse;
import com.work.on.customer.service.domain.dto.track.GetCustomerResponse;
import com.work.on.customer.service.domain.entity.Color;
import com.work.on.customer.service.domain.entity.Customer;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.SubscriptionType;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class CustomerDataMapper {

    public Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand) {
        return Customer
                .builder()
                .colorList(createCustomerCommand.getColorList().stream().map(colorCreate ->
                        Color.newBuilder()
                                .id(colorCreate.getColorId())
                                .hex(colorCreate.getHex())
                                .build()
                ).collect(Collectors.toList()))
                .subscriptionType(SubscriptionType.valueOf(createCustomerCommand.getSubscriptionType().name()))
                .name(createCustomerCommand.getFullName())
                .build();
    }
    public CreateCustomerResponse createCustomerCommandToCreateCustomerResponse(Customer customer, String message) {
        return new CreateCustomerResponse(customer.getId().getValue(), message);
    }

    public GetCustomerResponse customerToGetCustomerResponse(Customer customer) {
        return GetCustomerResponse.builder()
                .customerId(customer.getId())
                .failureMessages(customer.getFailureMessages())
                .build();
    }


}
