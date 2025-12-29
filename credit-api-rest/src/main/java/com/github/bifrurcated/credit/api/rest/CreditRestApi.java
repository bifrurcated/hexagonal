package com.github.bifrurcated.credit.api.rest;

import com.github.bifrurcated.credit.api.rest.dto.request.CreditOpenRequest;
import com.github.bifrurcated.credit.api.rest.dto.response.CreditOpenResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;

@OpenAPIDefinition(info = @Info(title = "API Кредитов"))
public interface CreditRestApi {


    CreditOpenResponse open(@Valid CreditOpenRequest request);
}
