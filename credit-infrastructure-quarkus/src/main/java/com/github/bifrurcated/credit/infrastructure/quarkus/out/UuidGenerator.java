package com.github.bifrurcated.credit.infrastructure.quarkus.out;

import com.github.bifrurcated.credit.domain.spi.IdGenerator;
import jakarta.enterprise.context.ApplicationScoped;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

@ApplicationScoped
public class UuidGenerator implements IdGenerator {

    @Override
    public @NonNull UUID generateUUID() {
        return UUID.randomUUID();
    }
}