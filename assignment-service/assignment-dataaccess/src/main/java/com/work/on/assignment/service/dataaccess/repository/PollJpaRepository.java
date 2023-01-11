package com.work.on.assignment.service.dataaccess.repository;

import com.work.on.assignment.service.dataaccess.entity.PollEntity;
import com.work.on.assignment.service.domain.entity.Poll;
import com.work.on.assignment.service.domain.valueobject.PollId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollJpaRepository extends JpaRepository<PollEntity, PollId> {
}
