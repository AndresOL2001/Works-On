package com.work.on.assigment.service.domain.ports.output.repository;

import com.work.on.assignment.service.domain.entity.File;
import com.work.on.domain.valueobject.FileId;

import java.util.Optional;

public interface FileRepository {

    Optional<File> findFileById(FileId fileId);

    File createFile(File file);
}
