package com.work.on.assignment.service.dataaccess.repository;

import com.work.on.assignment.service.dataaccess.entity.QuestionEntity;
import com.work.on.assignment.service.domain.valueobject.QuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, QuestionId> {
}
