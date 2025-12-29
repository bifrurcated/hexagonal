package com.github.bifrurcated.credit.domain.model;


import com.github.bifrurcated.credit.domain.model.valueobject.CreditExpirationDateFactory.CreditExpirationDate;
import com.github.bifrurcated.credit.domain.model.valueobject.CreditAmount;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record Credit(@NonNull UUID id,
                     @NonNull UUID userId,
                     @NonNull CreditStatus status,
                     @NonNull CreditAmount amount,
                     @NonNull String number,
                     @NonNull List<Operation> operations,
                     @NonNull CreditExpirationDate expirationDate) {

    public Credit(@NonNull UUID creditId, @NonNull UUID userId, @NonNull CreditAmount money, @NonNull String number, @NonNull CreditExpirationDate expirationDate) {
        this(creditId, userId, CreditStatus.ACTIVE, money, number, new ArrayList<>(), expirationDate);
    }
}
