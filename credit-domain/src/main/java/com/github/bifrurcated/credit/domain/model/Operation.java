package com.github.bifrurcated.credit.domain.model;

import com.github.bifrurcated.credit.domain.model.valueobject.OperationAmount;

import java.util.UUID;

public record Operation(UUID id, UUID creditId, OperationAmount amount, Direction direction) {

    public boolean isIncrease() { return direction == Direction.INCREASE; }

    public boolean isDecrease() { return direction == Direction.DECREASE; }
}
