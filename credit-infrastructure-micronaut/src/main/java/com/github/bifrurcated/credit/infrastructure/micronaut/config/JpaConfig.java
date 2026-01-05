package com.github.bifrurcated.credit.infrastructure.micronaut.config;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.DateTimeEntityListener;
import com.github.bifrurcated.credit.infrastructure.persistence.jpa.spi.EntityDateTimeProvider;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public class JpaConfig {

    @Bean
    public DateTimeEntityListener dateTimeEntityListener(EntityDateTimeProvider entityDateTimeProvider) {
        return new DateTimeEntityListener(entityDateTimeProvider);
    }
}
