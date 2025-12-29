package com.github.bifrurcated.credit.domain.spi.stubs;

import com.github.bifrurcated.credit.domain.spi.IdGenerator;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

@Stub
public class IdGeneratorStub implements IdGenerator {

    @NonNull
    @Override
    public UUID generateUUID() {
        return UUID.fromString("c76ab6cf-d892-4ca8-97ba-6ce55965ada9");
    }
}
