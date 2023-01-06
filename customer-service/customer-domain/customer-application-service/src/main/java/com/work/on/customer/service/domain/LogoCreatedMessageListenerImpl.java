package com.work.on.customer.service.domain;

import com.work.on.customer.service.domain.dto.message.LogoMessagingModel;
import com.work.on.customer.service.domain.entity.Customer;
import com.work.on.customer.service.domain.exception.CustomerDomainException;
import com.work.on.customer.service.domain.ports.input.message.listener.logo.LogoCreatedMessageListener;
import com.work.on.customer.service.domain.ports.output.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LogoCreatedMessageListenerImpl implements LogoCreatedMessageListener {
    public LogoCreatedMessageListenerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private final CustomerRepository customerRepository;

    @Override
    public void updateCustomerLogo(LogoMessagingModel customerModel) {
        Optional<Customer> customerOptional = customerRepository.findCustomer(customerModel.getCustomerId().getValue());
        if(customerOptional.isEmpty()){
            log.error("Error: The customer with id: {} doesn't exists is not possible update his logo",customerModel.getCustomerId().getValue().toString());
            throw new CustomerDomainException("Error: The customer with id: "+customerModel.getCustomerId().getValue().toString()+" " +
                    "doesn't exists is not possible update his logo");
        }
        Customer customer = customerOptional.get();
        customer.setLogo(customerModel.getUrl());
        Customer customerDB =  customerRepository.createCustomer(customer);
        if(customerDB != null){
            log.info("Customer with id: {} his logo was updated with fileId: {}",customerDB.getId().getValue().toString(),
                    customerDB.getLogo());
        }
    }
}
