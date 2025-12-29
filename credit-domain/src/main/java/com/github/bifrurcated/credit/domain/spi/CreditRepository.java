package com.github.bifrurcated.credit.domain.spi;

import com.github.bifrurcated.credit.domain.model.Credit;
import org.jspecify.annotations.NonNull;

public interface CreditRepository {
    void save(@NonNull Credit credit);
}
