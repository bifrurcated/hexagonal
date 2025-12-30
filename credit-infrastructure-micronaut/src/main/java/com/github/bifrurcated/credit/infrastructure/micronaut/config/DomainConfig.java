package com.github.bifrurcated.credit.infrastructure.micronaut.config;

import com.github.bifrurcated.credit.domain.service.CreditOpeningService;
import com.github.bifrurcated.credit.domain.spi.CreditRepository;
import com.github.bifrurcated.credit.domain.spi.IdGenerator;
import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import com.github.bifrurcated.credit.domain.spi.stubs.CreditAccountPoolStub;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public class DomainConfig {

    @Bean
    public CreditOpeningService creditOpeningService(
            TimeProvider timeProvider,
            CreditRepository creditRepository,
            IdGenerator idGenerator) {
        return new CreditOpeningService(timeProvider, new CreditAccountPoolStub(), creditRepository, idGenerator);
    }
}
