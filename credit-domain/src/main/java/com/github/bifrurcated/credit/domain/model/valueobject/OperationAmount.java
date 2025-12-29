package com.github.bifrurcated.credit.domain.model.valueobject;

import com.github.bifrurcated.credit.domain.exception.CreditAmountNegativeException;
import org.jspecify.annotations.NonNull;

import java.math.BigDecimal;

public record OperationAmount(@NonNull BigDecimal amount) {

    public OperationAmount {
        if (BigDecimal.ZERO.compareTo(amount) > 0) {
            throw new CreditAmountNegativeException();
        }
    }
}
