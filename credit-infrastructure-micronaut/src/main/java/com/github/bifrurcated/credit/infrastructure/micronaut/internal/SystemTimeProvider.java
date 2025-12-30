package com.github.bifrurcated.credit.infrastructure.micronaut.internal;

import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import jakarta.inject.Singleton;
import org.jspecify.annotations.NonNull;

import java.time.Clock;
import java.time.LocalDate;

@Singleton
public class SystemTimeProvider implements TimeProvider {

    private final Clock clock;

    public SystemTimeProvider() {
        this.clock = Clock.systemDefaultZone();
    }

    @NonNull
    @Override
    public LocalDate currentDate() {
        return LocalDate.now(clock);
    }
}
