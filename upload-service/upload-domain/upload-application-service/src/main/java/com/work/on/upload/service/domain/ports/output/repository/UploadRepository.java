package com.work.on.upload.service.domain.ports.output.repository;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileId;
import com.work.on.domain.valueobject.UserId;
import com.work.on.upload.service.domain.entity.File;

import java.util.List;
import java.util.Optional;


public interface UploadRepository {

     File saveFile(File file);

     Optional<File> getFile(FileId id);

     boolean deleteFile(FileId id);

     Optional<List<File>> getFilesByCustomerId(CustomerId id);

     List<File> getFilesByUserId(UserId id);

}
