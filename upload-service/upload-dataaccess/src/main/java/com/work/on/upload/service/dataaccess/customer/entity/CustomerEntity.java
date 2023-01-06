package com.work.on.upload.service.dataaccess.customer.entity;

import com.work.on.upload.service.dataaccess.upload.entity.FileEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_view",schema = "uploadworkon")
@Entity
public class CustomerEntity {

    @Id
    private UUID customerId;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> files;

}
