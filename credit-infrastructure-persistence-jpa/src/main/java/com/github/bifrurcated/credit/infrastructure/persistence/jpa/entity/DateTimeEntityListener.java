package com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.spi.EntityDateTimeProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@ApplicationScoped
public class DateTimeEntityListener {

    private final EntityDateTimeProvider entityDateTimeProvider;

    @Inject
    public DateTimeEntityListener(EntityDateTimeProvider entityDateTimeProvider) {
        this.entityDateTimeProvider = entityDateTimeProvider;
    }

    @PrePersist
    public void onPrePersist(BaseEntity entity) {
        var now = entityDateTimeProvider.currentDateTime();
        entity.setCreateTime(now);
        entity.setUpdateTime(now);
    }

    @PreUpdate
    public void onPreUpdate(BaseEntity entity) {
        entity.setUpdateTime(entityDateTimeProvider.currentDateTime());
    }
}
