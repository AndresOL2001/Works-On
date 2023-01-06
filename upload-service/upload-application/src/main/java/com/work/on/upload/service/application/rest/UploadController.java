package com.work.on.upload.service.application.rest;

import com.work.on.upload.service.domain.dto.create.CreateLogoCommand;
import com.work.on.upload.service.domain.dto.create.CreateLogoResponse;
import com.work.on.upload.service.domain.ports.input.service.UploadApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/customers", produces = "application/vnd.api.v1+json")
public class UploadController {

    public UploadController(UploadApplicationService uploadApplicationService) {
        this.uploadApplicationService = uploadApplicationService;
    }
    private final UploadApplicationService uploadApplicationService;

    @PostMapping
    public ResponseEntity<CreateLogoResponse> createCustomer(@RequestParam("logo") MultipartFile file,@RequestParam("customer") UUID customerId) {
        log.info("Creating Logo for customer Id: {}", customerId);
        CreateLogoCommand createLogoCommand = uploadApplicationService.saveLogo(file,customerId);
        CreateLogoResponse response = uploadApplicationService.createLogo(createLogoCommand);
        return ResponseEntity.ok(response);
    }
}
