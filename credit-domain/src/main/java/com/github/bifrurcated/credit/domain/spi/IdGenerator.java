package com.github.bifrurcated.credit.domain.spi;

import org.jspecify.annotations.NonNull;

import java.util.UUID;

public interface IdGenerator {

    @NonNull
    UUID generateUUID();
}
