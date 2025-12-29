package com.github.bifrurcated.credit.domain.spi.stubs;

import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.domain.spi.CreditRepository;
import org.jspecify.annotations.NonNull;

@Stub
public class CreditRepositoryStub implements CreditRepository {

    @Override
    public void save(@NonNull Credit credit) {

    }
}
