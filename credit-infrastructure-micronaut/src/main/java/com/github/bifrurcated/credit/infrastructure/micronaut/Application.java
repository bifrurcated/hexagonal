package com.github.bifrurcated.credit.infrastructure.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.persistence.Entity;

@OpenAPIDefinition(
        info = @Info(
                title = "credit-infrastructure-micronaut",
                version = "0.0"
        )
)
@Introspected(
        packages = {
                "com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity"
        },
        includedAnnotations = {Entity.class}
)
public class Application {

    static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
