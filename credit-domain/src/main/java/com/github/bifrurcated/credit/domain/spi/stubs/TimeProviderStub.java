package com.github.bifrurcated.credit.domain.spi.stubs;

import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import org.jspecify.annotations.NonNull;

import java.time.LocalDate;
import java.time.Month;

@Stub
public class TimeProviderStub implements TimeProvider {

    @NonNull
    @Override
    public LocalDate currentDate() {
        return LocalDate.of(2025, Month.JANUARY, 27);
    }
}
