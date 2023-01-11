package com.work.on.assignment.service.dataaccess.repository;

import com.work.on.assignment.service.dataaccess.entity.AssignmentEntity;
import com.work.on.assignment.service.domain.entity.Assignment;
import com.work.on.domain.valueobject.AssignmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentJpaRepository extends JpaRepository<AssignmentEntity, AssignmentId> {
}
