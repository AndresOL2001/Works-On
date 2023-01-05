package com.work.on.user.service.application.rest;

import com.work.on.application.service.domain.dto.create.CreateUserCommand;
import com.work.on.application.service.domain.dto.create.CreateUserResponse;
import com.work.on.application.service.domain.dto.track.GetUserResponse;
import com.work.on.application.service.domain.dto.track.GetUsersResponse;
import com.work.on.application.service.domain.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/users", produces = "application/vnd.api.v1+json")
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateUserResponse> createCustomer(@RequestBody List<CreateUserCommand>
                                                                         createCustomerCommands) {
        log.info("Creating users with size: {}", createCustomerCommands.size());
        CreateUserResponse response = userApplicationService.createUser(createCustomerCommands);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/xlsx")
    public ResponseEntity<CreateUserResponse> createCustomerXlsx(@RequestParam("file") MultipartFile file) {

        List<CreateUserCommand> createUserCommands = userApplicationService.createUserXlsx(file);
       log.info("Creating users with size: {}", createUserCommands.size());
        CreateUserResponse response = userApplicationService.createUser(createUserCommands);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/xls")
    public ResponseEntity<CreateUserResponse> createCustomerXls(@RequestParam("file") MultipartFile file) {

        List<CreateUserCommand> createUserCommands = userApplicationService.createUserXls(file);
        log.info("Creating users with size: {}", createUserCommands.size());
        CreateUserResponse response = userApplicationService.createUser(createUserCommands);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/csv")
    public ResponseEntity<CreateUserResponse> createCustomerCsv(@RequestParam("file") MultipartFile file) {

        List<CreateUserCommand> createUserCommands = userApplicationService.createUserCsv(file);
        log.info("Creating users with size: {}", createUserCommands.size());
        CreateUserResponse response = userApplicationService.createUser(createUserCommands);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{controlNumber}")
    public ResponseEntity<GetUserResponse> getUserByControlNumber(@PathVariable String controlNumber) {

        GetUserResponse getUserResponse = userApplicationService.getUserByControlNumber(controlNumber);
        return ResponseEntity.ok(getUserResponse);
    }

    @GetMapping("/{country}/{state}/{zone}")
    public ResponseEntity<GetUsersResponse> getUserByZoneCountryAndState(@PathVariable String country,
                                                                        @PathVariable String zone,
                                                                        @PathVariable String state) {

        GetUsersResponse getUsersResponse = userApplicationService.getUserByCountryAndStateAndZone(country,state,zone);
        return ResponseEntity.ok(getUsersResponse);
    }
}
