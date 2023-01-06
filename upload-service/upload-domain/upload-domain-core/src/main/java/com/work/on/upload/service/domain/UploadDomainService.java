package com.work.on.upload.service.domain;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileId;
import com.work.on.upload.service.domain.entity.File;
import com.work.on.upload.service.domain.event.LogoCreatedEvent;

public interface UploadDomainService {

    LogoCreatedEvent logoCreatedEvent(File file);

    LogoCreatedEvent logoUpdatedEvent(File file, FileId fileId);


}
