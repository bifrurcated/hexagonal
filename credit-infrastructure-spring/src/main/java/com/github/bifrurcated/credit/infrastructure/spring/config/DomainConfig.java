package com.github.bifrurcated.credit.infrastructure.spring.config;

import com.github.bifrurcated.credit.domain.service.DomainService;
import com.github.bifrurcated.credit.domain.spi.stubs.CreditRepositoryStub;
import com.github.bifrurcated.credit.domain.spi.stubs.IdGeneratorStub;
import com.github.bifrurcated.credit.domain.spi.stubs.Stub;
import com.github.bifrurcated.credit.domain.spi.stubs.TimeProviderStub;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.github.bifrurcated.credit.domain",
        includeFilters = @Filter(type = FilterType.ANNOTATION, classes = {DomainService.class, Stub.class}),
        excludeFilters = @Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {CreditRepositoryStub.class, IdGeneratorStub.class, TimeProviderStub.class}
        )
)
public class DomainConfig {
}
