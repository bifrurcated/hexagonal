package com.github.bifrurcated.credit.infrastructure.micronaut.internal;

import com.github.bifrurcated.credit.domain.spi.IdGenerator;
import jakarta.inject.Singleton;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

@Singleton
public class UuidGenerator implements IdGenerator {

    @Override
    public @NonNull UUID generateUUID() {
        return UUID.randomUUID();
    }
}
