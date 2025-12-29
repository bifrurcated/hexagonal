package com.github.bifrurcated.credit.infrastructure.spring.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity")
@EnableJpaRepositories(basePackages = "com.github.bifrurcated.credit.infrastructure.persistence.jpa")
@Configuration
public class JpaConfig {
}
