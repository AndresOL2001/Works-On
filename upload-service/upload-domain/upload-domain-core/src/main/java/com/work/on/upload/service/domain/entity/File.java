package com.work.on.upload.service.domain.entity;

import com.work.on.domain.entity.AgregateRoot;
import com.work.on.domain.valueobject.CustomerId;
import com.work.on.domain.valueobject.FileId;
import com.work.on.domain.valueobject.FileType;
import com.work.on.domain.valueobject.TopicType;
import com.work.on.upload.service.domain.exception.UploadDomainException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class File extends AgregateRoot<FileId> {
    private final String title;

    private final String url;

    private final FileType type;

    private  ZonedDateTime createdAt;

    private  CustomerId customerId;

    private TopicType topic;



    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void initiateFile(){
        setId(new FileId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        if(getId() == null){
            throw new UploadDomainException("File is not in correct state for initialization (Id or date not initialized correctly)!");
        }
    }
    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }
    public void initiateLogo(){
        topic = TopicType.LOGO;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void validateIsImage(File file){
        if(file.type != FileType.IMAGE){
            throw new UploadDomainException("Logos cannot be documents or videos");
        }
    }

    private File(Builder builder) {
        setId(builder.id);
        title = builder.title;
        topic = builder.topic;
        url = builder.url;
        type = builder.type;
        createdAt = builder.createdAt;
        customerId = builder.customerId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public FileType getType() {
        return type;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public TopicType getTopic() {
        return topic;
    }


    public static final class Builder {
        private FileId id;
        private String title;

        private TopicType topic;

        private String url;
        private FileType type;
        private ZonedDateTime createdAt;
        private CustomerId customerId;

        private Builder() {
        }

        public Builder id(FileId val) {
            id = val;
            return this;
        }

        public Builder topicType(TopicType val) {
            topic = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Builder type(FileType val) {
            type = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public File build() {
            return new File(this);
        }
    }
}
