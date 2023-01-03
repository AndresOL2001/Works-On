package com.work.on.customer.service.domain.ports.input.service;


import com.work.on.customer.service.domain.dto.create.CreateCustomerCommand;
import com.work.on.customer.service.domain.dto.create.CreateCustomerResponse;
import com.work.on.customer.service.domain.dto.track.GetCustomerQuery;
import com.work.on.customer.service.domain.dto.track.GetCustomerResponse;
import com.work.on.customer.service.domain.entity.Color;

import javax.validation.Valid;
import java.util.List;

public interface CustomerApplicationService {

    CreateCustomerResponse createCustomer(@Valid CreateCustomerCommand createCustomerCommand);

    GetCustomerResponse trackOrder(@Valid GetCustomerQuery getCustomerQuery);

     Color getColorById(Long id);

     List<Color> getColors();
}
