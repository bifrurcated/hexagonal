package com.github.bifrurcated.credit.api.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.AdditionalPropertiesValue.FALSE;

@Schema(description = "Запрос на открытие кредитного продукта", additionalProperties = FALSE)
public record CreditOpenRequest(

        @NotNull
        @Schema(description = "Идентификатор пользователя")
        UUID userId,

        @DecimalMin("10.00")
        @Positive
        @Digits(integer = 11, fraction = 2)
        @NotNull
        @Schema(description = "Сумма кредита")
        BigDecimal amount,

        @NotNull
        @Schema(description = "Дата истичения срока действия кредита")
        LocalDate expirationDate
) {
}
