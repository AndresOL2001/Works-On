package com.work.on.user.service.dataaccess.customer.repository;

import com.work.on.domain.valueobject.CustomerId;
import com.work.on.user.service.dataaccess.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, CustomerId> {

    Optional<CustomerEntity> findByName(String name);

}
