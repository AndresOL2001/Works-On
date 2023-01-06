package com.work.on.upload.service.dataaccess.upload.mapper;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileId;
import com.work.on.upload.service.dataaccess.customer.entity.CustomerEntity;
import com.work.on.upload.service.dataaccess.upload.entity.FileEntity;
import com.work.on.upload.service.domain.entity.File;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UploadDataAccessMapper {

    public File fileEntityToFile(FileEntity fileEntity){
        return File.newBuilder()
                .id(new FileId(fileEntity.getFileId()))
                .customerId(new CustomerId(fileEntity.getCustomer().getCustomerId()))
                .type(fileEntity.getType())
                .title(fileEntity.getTitle())
                .createdAt(fileEntity.getCreatedAt())
                .url(fileEntity.getUrl())
                .topicType(fileEntity.getTopic())
                .build();
    }

    public FileEntity fileToFileEntity(File file){
        return FileEntity.builder()
                .fileId(file.getId().getValue())
                .type(file.getType())
                .title(file.getTitle())
                .topic(file.getTopic())
                .customer(CustomerEntity.builder()
                        .customerId(file.getCustomerId().getValue())
                        .build())
                .createdAt(file.getCreatedAt())
                .url(file.getUrl())
                .build();
    }

    public List<File> filesEntitiesToFiles(List<FileEntity> filesEntities) {
        return filesEntities.stream().map(fileEntity ->
                File.newBuilder()
                        .id(new FileId(fileEntity.getFileId()))
                        .url(fileEntity.getUrl())
                        .customerId(new CustomerId(fileEntity.getCustomer().getCustomerId()))
                        .type(fileEntity.getType())
                        .title(fileEntity.getTitle())
                        .createdAt(fileEntity.getCreatedAt())
                        .topicType(fileEntity.getTopic())
                        .build()
                ).collect(Collectors.toList());
    }
}
