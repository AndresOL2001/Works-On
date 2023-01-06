package com.work.on.upload.service.domain.ports.input.service;

import com.work.on.upload.service.domain.dto.create.CreateLogoCommand;
import com.work.on.upload.service.domain.dto.create.CreateLogoResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UploadApplicationService {

    CreateLogoResponse createLogo(@Valid CreateLogoCommand createLogoCommand);
    CreateLogoCommand saveLogo(@Valid  MultipartFile file,UUID customerId);
}
