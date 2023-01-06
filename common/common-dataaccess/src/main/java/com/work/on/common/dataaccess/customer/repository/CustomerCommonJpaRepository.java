package com.work.on.common.dataaccess.customer.repository;

import com.work.on.common.dataaccess.customer.entity.CustomerCommonEntity;
import com.work.on.domain.valueobject.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerCommonJpaRepository extends JpaRepository<CustomerCommonEntity, CustomerId> {

    Optional<CustomerCommonEntity> findByName(String name);

}
