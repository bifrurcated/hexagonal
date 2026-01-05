package com.github.bifrurcated.credit.infrastructure.spring.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;

@EntityScan(basePackages = "com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity")
@Configuration
public class JpaConfig {
}
