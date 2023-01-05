package com.work.on.user.service.dataaccess.customer.repository;

import com.work.on.user.service.dataaccess.customer.entity.CustomerEntity;
import com.work.on.user.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {

    Optional<CustomerEntity> findByName(String name);

}
