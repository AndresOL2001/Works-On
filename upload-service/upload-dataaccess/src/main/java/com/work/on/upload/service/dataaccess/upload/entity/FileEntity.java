package com.work.on.upload.service.dataaccess.upload.entity;

import com.work.on.domain.valueobject.FileType;
import com.work.on.domain.valueobject.TopicType;
import com.work.on.domain.valueobject.UserId;
import com.work.on.upload.service.dataaccess.customer.entity.CustomerEntity;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "files",schema = "uploadworkon")
@Entity
public class FileEntity {

    @Id
    private UUID fileId;

    private String title;

    private String url;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private TopicType topic;

    private ZonedDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    private UUID userId;
}
