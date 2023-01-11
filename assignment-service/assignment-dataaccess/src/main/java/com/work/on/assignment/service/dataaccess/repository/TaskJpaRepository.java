package com.work.on.assignment.service.dataaccess.repository;

import com.work.on.assignment.service.dataaccess.entity.TaskEntity;
import com.work.on.assignment.service.domain.valueobject.TaskId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskEntity, TaskId> {
}
