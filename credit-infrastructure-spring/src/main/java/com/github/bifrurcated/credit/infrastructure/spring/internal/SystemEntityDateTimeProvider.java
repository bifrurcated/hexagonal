package com.github.bifrurcated.credit.infrastructure.spring.internal;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.spi.EntityDateTimeProvider;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class SystemEntityDateTimeProvider implements EntityDateTimeProvider {

    private final Clock clock;

    public SystemEntityDateTimeProvider() {
        this.clock = Clock.systemDefaultZone();
    }

    @Override
    public @NonNull LocalDateTime currentDateTime() {
        return LocalDateTime.now(clock);
    }
}
