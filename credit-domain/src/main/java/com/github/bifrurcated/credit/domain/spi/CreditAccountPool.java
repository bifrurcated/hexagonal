package com.github.bifrurcated.credit.domain.spi;

import org.jspecify.annotations.NonNull;

public interface CreditAccountPool {

    @NonNull
    String getAccountNumber();
}
