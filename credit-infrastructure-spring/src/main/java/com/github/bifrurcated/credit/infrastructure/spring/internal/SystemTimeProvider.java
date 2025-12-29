package com.github.bifrurcated.credit.infrastructure.spring.internal;

import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;

@Service
public class SystemTimeProvider implements TimeProvider {

    private final Clock clock;

    public SystemTimeProvider() {
        this.clock = Clock.systemDefaultZone();
    }

    @Override
    public LocalDate currentDate() {
        return LocalDate.now(clock);
    }
}
