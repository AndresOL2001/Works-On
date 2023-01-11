package com.work.on.assignment.service.dataaccess.repository;

import com.work.on.assignment.service.dataaccess.entity.FileEntity;
import com.work.on.domain.valueobject.FileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileJpaRepository extends JpaRepository<FileEntity, FileId> {
}
