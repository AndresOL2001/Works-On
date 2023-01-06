package com.work.on.domain.valueobject;

import java.util.UUID;

public class FileId extends BaseId<UUID> {
    public FileId(UUID value) {
        super(value);
    }
}
