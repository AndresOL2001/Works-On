package com.work.on.customer.service.domain;

import com.work.on.customer.service.domain.dto.track.GetCustomerQuery;
import com.work.on.customer.service.domain.dto.track.GetCustomerResponse;
import com.work.on.customer.service.domain.entity.Customer;
import com.work.on.customer.service.domain.exception.CustomerNotFoundException;
import com.work.on.customer.service.domain.mapper.CustomerDataMapper;
import com.work.on.customer.service.domain.ports.output.repository.CustomerRepository;
import com.work.on.domain.valueobject.CustomerId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Slf4j
@Component
public class GetCustomerQueryHandler {
    private final CustomerDataMapper customerDataMapper;

    private final CustomerRepository customerRepository;

    public GetCustomerQueryHandler(CustomerDataMapper customerDataMapper, CustomerRepository customerRepository) {
        this.customerDataMapper = customerDataMapper;
        this.customerRepository = customerRepository;
    }


    @Transactional(readOnly = true)
    public GetCustomerResponse trackOrder(GetCustomerQuery trackOrderQuery) {
        Optional<Customer> orderResult =
                customerRepository.findCustomer(trackOrderQuery.getCustomerId().getValue());
        if (orderResult.isEmpty()) {
            log.warn("Could not find customer with tracking id: {}", trackOrderQuery.getCustomerId().getValue());
            throw new CustomerNotFoundException("Could not find customer with tracking id: " +
                    trackOrderQuery.getCustomerId().getValue());
        }
        return customerDataMapper.customerToGetCustomerResponse(orderResult.get());
    }
}
