package com.github.bifrurcated.credit.domain.model.valueobject;

import com.github.bifrurcated.credit.domain.exception.CreditAmountNegativeException;
import org.jspecify.annotations.NonNull;

import java.math.BigDecimal;

public record CreditAmount(@NonNull BigDecimal value) {

    public CreditAmount {
        if (BigDecimal.ZERO.compareTo(value) > 0) {
            throw new CreditAmountNegativeException();
        }
    }
}
