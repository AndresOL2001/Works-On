package com.work.on.customer.service.dataaccess.repository;

import com.work.on.customer.service.dataaccess.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorJpaRepository extends JpaRepository<ColorEntity, Long> {

}
