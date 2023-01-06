package com.work.on.upload.service.dataaccess.customer.repository;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.upload.service.dataaccess.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, CustomerId> {
    Optional<CustomerEntity> findByName(String name);

}
