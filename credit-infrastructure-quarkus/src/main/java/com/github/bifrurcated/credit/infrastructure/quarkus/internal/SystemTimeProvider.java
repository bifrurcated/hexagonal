package com.github.bifrurcated.credit.infrastructure.quarkus.internal;

import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import jakarta.enterprise.context.ApplicationScoped;
import org.jspecify.annotations.NonNull;

import java.time.Clock;
import java.time.LocalDate;

@ApplicationScoped
public class SystemTimeProvider implements TimeProvider {

    private final Clock clock;

    public SystemTimeProvider() {
        this.clock = Clock.systemDefaultZone();
    }

    @Override
    public @NonNull LocalDate currentDate() {
        return LocalDate.now(clock);
    }
}
