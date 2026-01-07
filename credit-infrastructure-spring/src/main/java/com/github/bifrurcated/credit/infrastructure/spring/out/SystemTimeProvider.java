package com.github.bifrurcated.credit.infrastructure.spring.out;

import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;

@Service
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
