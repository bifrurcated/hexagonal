package com.github.bifrurcated.credit.infrastructure.spring.internal;

import com.github.bifrurcated.credit.domain.spi.IdGenerator;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidGenerator implements IdGenerator {

    @Override
    public @NonNull UUID generateUUID() {
        return UUID.randomUUID();
    }
}
