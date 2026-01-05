package com.github.bifrurcated.credit.infrastructure.persistence.jpa.spi;

import org.jspecify.annotations.NonNull;

import java.time.LocalDateTime;

public interface EntityDateTimeProvider {

    @NonNull
    LocalDateTime currentDateTime();
}
