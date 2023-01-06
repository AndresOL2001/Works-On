package com.work.on.upload.service.dataaccess.upload.repository;

import com.work.on.upload.service.dataaccess.upload.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UploadJpaRepository extends JpaRepository<FileEntity, UUID> {

    List<FileEntity> findByCustomerCustomerId (UUID customerId);

}
