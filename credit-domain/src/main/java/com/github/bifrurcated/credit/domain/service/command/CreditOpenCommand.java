package com.github.bifrurcated.credit.domain.service.command;

import org.jspecify.annotations.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreditOpenCommand(@NonNull UUID userId, @NonNull BigDecimal amount, @NonNull LocalDate expirationDate) {
}
