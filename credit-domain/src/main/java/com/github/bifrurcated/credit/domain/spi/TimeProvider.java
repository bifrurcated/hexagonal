package com.github.bifrurcated.credit.domain.spi;

import org.jspecify.annotations.NonNull;

import java.time.LocalDate;

public interface TimeProvider {

    @NonNull
    LocalDate currentDate();
}
