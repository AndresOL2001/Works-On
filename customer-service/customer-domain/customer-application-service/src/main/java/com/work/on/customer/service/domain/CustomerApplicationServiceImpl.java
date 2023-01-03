package com.work.on.customer.service.domain;

import com.work.on.customer.service.domain.dto.create.CreateCustomerCommand;
import com.work.on.customer.service.domain.dto.create.CreateCustomerResponse;
import com.work.on.customer.service.domain.dto.track.GetCustomerQuery;
import com.work.on.customer.service.domain.dto.track.GetCustomerResponse;
import com.work.on.customer.service.domain.entity.Color;
import com.work.on.customer.service.domain.event.CustomerCreatedEvent;
import com.work.on.customer.service.domain.mapper.CustomerDataMapper;
import com.work.on.customer.service.domain.ports.input.service.CustomerApplicationService;
import com.work.on.customer.service.domain.ports.output.message.publisher.payment.CustomerMessagePublisher;
import com.work.on.customer.service.domain.ports.output.repository.ColorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Validated
@Service
public class CustomerApplicationServiceImpl implements CustomerApplicationService {

    private final CustomerCreateCommandHandler customerCreateCommandHandler;

    private final GetCustomerQueryHandler getCustomerQueryHandler;

    private final CustomerDataMapper customerDataMapper;

    private final CustomerMessagePublisher customerMessagePublisher;

    private final ColorRepository colorRepository;

    public CustomerApplicationServiceImpl(CustomerCreateCommandHandler customerCreateCommandHandler, GetCustomerQueryHandler getCustomerQueryHandler, CustomerDataMapper customerDataMapper, CustomerMessagePublisher customerMessagePublisher, ColorRepository colorRepository) {
        this.customerCreateCommandHandler = customerCreateCommandHandler;
        this.getCustomerQueryHandler = getCustomerQueryHandler;
        this.customerDataMapper = customerDataMapper;
        this.customerMessagePublisher = customerMessagePublisher;
        this.colorRepository = colorRepository;
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerCommand createCustomerCommand) {
        CustomerCreatedEvent customerCreatedEvent = customerCreateCommandHandler.createCustomer(createCustomerCommand);
        customerMessagePublisher.publish(customerCreatedEvent);
        return customerDataMapper
                .createCustomerCommandToCreateCustomerResponse(customerCreatedEvent.getCustomer(),
                        "Customer saved successfully!");
    }

    @Override
    public GetCustomerResponse trackOrder(GetCustomerQuery getCustomerQuery) {
        return getCustomerQueryHandler.trackOrder(getCustomerQuery);
    }
    @Override
    public Color getColorById(Long id){
        return colorRepository.findColor(id).get();
    }

    @Override
    public List<Color> getColors() {
        return colorRepository.getAllColors().get();
    }

}
