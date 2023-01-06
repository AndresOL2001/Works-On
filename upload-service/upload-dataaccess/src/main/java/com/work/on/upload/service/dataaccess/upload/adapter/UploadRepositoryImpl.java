package com.work.on.upload.service.dataaccess.upload.adapter;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileId;
import com.work.on.domain.valueobject.UserId;
import com.work.on.upload.service.dataaccess.upload.mapper.UploadDataAccessMapper;
import com.work.on.upload.service.dataaccess.upload.repository.UploadJpaRepository;
import com.work.on.upload.service.domain.entity.File;
import com.work.on.upload.service.domain.ports.output.repository.UploadRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UploadRepositoryImpl implements UploadRepository {

    private final UploadJpaRepository uploadJpaRepository;

    private final UploadDataAccessMapper uploadDataAcessMapper;

    public UploadRepositoryImpl(UploadJpaRepository uploadJpaRepository, UploadDataAccessMapper uploadDataAcessMapper) {
        this.uploadJpaRepository = uploadJpaRepository;
        this.uploadDataAcessMapper = uploadDataAcessMapper;
    }

    @Override
    public File saveFile(File file) {

        return uploadDataAcessMapper.fileEntityToFile(
                uploadJpaRepository.save(uploadDataAcessMapper.fileToFileEntity(file)));
    }

    @Override
    public Optional<File> getFile(FileId id) {

        return uploadJpaRepository.findById(id.getValue()).map(uploadDataAcessMapper :: fileEntityToFile);
    }

    @Override
    public boolean deleteFile(FileId id) {
        return false;
    }

    @Override
    public Optional<List<File>> getFilesByCustomerId(CustomerId id) {

        return Optional.of(uploadDataAcessMapper.filesEntitiesToFiles(uploadJpaRepository.findByCustomerCustomerId(id.getValue())));

    }

    @Override
    public List<File> getFilesByUserId(UserId id) {
        return null;
    }
}
