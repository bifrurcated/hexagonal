package com.github.bifrurcated.credit.infrastructure.spring.config;

import com.github.bifrurcated.credit.infrastructure.spring.out.AccountPoolRestClient;
import org.springframework.boot.restclient.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.service.registry.HttpServiceGroup;
import org.springframework.web.service.registry.ImportHttpServices;

@ImportHttpServices(
        group = "account-pool",
        value = AccountPoolRestClient.class,
        clientType = HttpServiceGroup.ClientType.REST_CLIENT
)
@Configuration(proxyBeanMethods = false)
public class HttpClientConfig {

    @Bean
    public RestClientCustomizer restClientCustomizer() {
        return customizer -> customizer
                .defaultStatusHandler(new DefaultResponseErrorHandler());
    }
}
