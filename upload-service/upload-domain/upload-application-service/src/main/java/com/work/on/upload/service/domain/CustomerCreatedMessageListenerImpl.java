package com.work.on.upload.service.domain;

import com.work.on.upload.service.domain.dto.message.CustomerMessagingModel;
import com.work.on.upload.service.domain.entity.Customer;
import com.work.on.upload.service.domain.exception.UploadDomainException;
import com.work.on.upload.service.domain.mapper.UploadDataMapper;
import com.work.on.upload.service.domain.ports.input.message.listener.upload.CustomerCreatedMessageListener;
import com.work.on.upload.service.domain.ports.output.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerCreatedMessageListenerImpl implements CustomerCreatedMessageListener {

    private final CustomerRepository customerRepository;

    private final UploadDataMapper uploadDataMapper;

    public CustomerCreatedMessageListenerImpl(CustomerRepository customerRepository, UploadDataMapper uploadDataMapper) {
        this.customerRepository = customerRepository;
        this.uploadDataMapper = uploadDataMapper;
    }

    @Override
    public void customerCreated(CustomerMessagingModel customerModel) {
        Customer customer = customerRepository.createCustomer(uploadDataMapper.customerModelToCustomer(customerModel));
        if (customer == null) {
            log.error("Customer could not be created in order database with id: {}", customer.getId());
            throw new UploadDomainException("Customer could not be created in uploads database with id " +
                    customer.getId());
        }
        log.info("Customer is created in uploads database with id: {}", customer.getId());
    }
}
