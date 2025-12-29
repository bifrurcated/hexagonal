package com.github.bifrurcated.credit.domain.spi.stubs;

import com.github.bifrurcated.credit.domain.spi.CreditAccountPool;
import org.jspecify.annotations.NonNull;

@Stub
public class CreditAccountPoolStub implements CreditAccountPool {

    @NonNull
    @Override
    public String getAccountNumber() {
        return "1234567890";
    }
}
