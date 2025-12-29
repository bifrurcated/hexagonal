package com.github.bifrurcated.credit.api.rest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.AdditionalPropertiesValue.FALSE;

@Schema(description = "Ответ на запрос по открытию кредитного продукта", additionalProperties = FALSE)
public record CreditOpenResponse(

        @Schema(description = "Идентификатор кредита")
        UUID id,

        @Schema(description = "Статус кредита")
        String status,

        @Schema(description = "Кредитный номер счета")
        String number
) {
}
