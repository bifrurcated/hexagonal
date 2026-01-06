package com.github.bifrurcated.credit.infrastructure.quarkus.out;

import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import jakarta.enterprise.context.ApplicationScoped;
import org.jspecify.annotations.NonNull;

import java.time.Clock;
import java.time.LocalDate;

@ApplicationScoped
public class SystemTimeProvider implements TimeProvider {

    private final Clock clock;

    public SystemTimeProvider(Clock clock) {
        this.clock = clock;
    }

    @Override
    public @NonNull LocalDate currentDate() {
        return LocalDate.now(clock);
    }
}
