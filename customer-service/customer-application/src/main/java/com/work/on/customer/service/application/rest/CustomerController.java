package com.work.on.customer.service.application.rest;

import com.work.on.customer.service.domain.dto.create.CreateCustomerCommand;
import com.work.on.customer.service.domain.dto.create.CreateCustomerResponse;
import com.work.on.customer.service.domain.dto.track.GetCustomerQuery;
import com.work.on.customer.service.domain.dto.track.GetCustomerResponse;
import com.work.on.customer.service.domain.entity.Color;
import com.work.on.customer.service.domain.ports.input.service.CustomerApplicationService;
import com.work.on.domain.valueobject.CustomerId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/customers", produces = "application/vnd.api.v1+json")
public class CustomerController {

    private final CustomerApplicationService customerApplicationService;

    public CustomerController(CustomerApplicationService customerApplicationService) {
        this.customerApplicationService = customerApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody CreateCustomerCommand
                                                                         createCustomerCommand) {
        log.info("Creating customer with username: {}", createCustomerCommand.getFullName());
        CreateCustomerResponse response = customerApplicationService.createCustomer(createCustomerCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<GetCustomerResponse> getCustomerById(@PathVariable UUID trackingId) {
        GetCustomerResponse trackOrderResponse =
                customerApplicationService.trackOrder(GetCustomerQuery.builder().customerId(new CustomerId(trackingId)).build());
        log.info("Returning order status with tracking id: {}", trackOrderResponse.getCustomerId());
        return  ResponseEntity.ok(trackOrderResponse);
    }


    @GetMapping("/colors/{colorId}")
    public ResponseEntity<Color> getCustomerById(@PathVariable Long colorId) {
        Color color =
                customerApplicationService.getColorById(colorId);
        return  ResponseEntity.ok(color);
    }

    @GetMapping("/colors")
    public ResponseEntity<List<Color>> getColors() {
        List<Color> colors =
                customerApplicationService.getColors();
        return  ResponseEntity.ok(colors);
    }
}
