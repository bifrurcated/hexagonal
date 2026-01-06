package com.github.bifrurcated.credit.infrastructure.micronaut.out;

import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import jakarta.inject.Singleton;
import org.jspecify.annotations.NonNull;

import java.time.Clock;
import java.time.LocalDate;

@Singleton
public class SystemTimeProvider implements TimeProvider {

    private final Clock clock;

    public SystemTimeProvider(Clock clock) {
        this.clock = clock;
    }

    @NonNull
    @Override
    public LocalDate currentDate() {
        return LocalDate.now(clock);
    }
}
