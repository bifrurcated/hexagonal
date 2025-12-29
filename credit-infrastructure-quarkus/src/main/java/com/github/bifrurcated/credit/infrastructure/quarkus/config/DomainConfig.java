package com.github.bifrurcated.credit.infrastructure.quarkus.config;

import com.github.bifrurcated.credit.domain.service.CreditOpeningService;
import com.github.bifrurcated.credit.domain.spi.CreditRepository;
import com.github.bifrurcated.credit.domain.spi.IdGenerator;
import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import com.github.bifrurcated.credit.domain.spi.stubs.CreditAccountPoolStub;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class DomainConfig {

    @Produces
    @ApplicationScoped
    public CreditOpeningService creditOpeningService(
            TimeProvider timeProvider,
            CreditRepository creditRepository,
            IdGenerator idGenerator) {
        return new CreditOpeningService(timeProvider, new CreditAccountPoolStub(), creditRepository, idGenerator);
    }
}
