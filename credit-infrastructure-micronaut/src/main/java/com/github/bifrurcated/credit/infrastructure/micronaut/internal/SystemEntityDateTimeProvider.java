package com.github.bifrurcated.credit.infrastructure.micronaut.internal;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.spi.EntityDateTimeProvider;
import jakarta.inject.Singleton;
import org.jspecify.annotations.NonNull;

import java.time.Clock;
import java.time.LocalDateTime;

@Singleton
public class SystemEntityDateTimeProvider implements EntityDateTimeProvider {

    private final Clock clock;

    public SystemEntityDateTimeProvider(Clock clock) {
        this.clock = clock;
    }

    @Override
    public @NonNull LocalDateTime currentDateTime() {
        return LocalDateTime.now(clock);
    }
}
