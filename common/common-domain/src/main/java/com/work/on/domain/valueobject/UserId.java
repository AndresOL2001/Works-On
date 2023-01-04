package com.work.on.domain.valueobject;

import java.util.UUID;

public class UserId extends BaseId<UUID>{
    public UserId(UUID value) {
        super(value);
    }
}
