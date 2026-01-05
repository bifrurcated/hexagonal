package com.github.bifrurcated.credit.infrastructure.quarkus.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.time.Clock;

@ApplicationScoped
public class TimeConfig {

    @Produces
    @ApplicationScoped
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
