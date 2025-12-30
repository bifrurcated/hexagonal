package com.github.bifrurcated.credit.infrastructure.micronaut.in;

import com.github.bifrurcated.credit.api.rest.CreditRestApi;
import com.github.bifrurcated.credit.api.rest.dto.request.CreditOpenRequest;
import com.github.bifrurcated.credit.api.rest.dto.response.CreditOpenResponse;
import com.github.bifrurcated.credit.domain.service.CreditOpeningService;
import com.github.bifrurcated.credit.infrastructure.micronaut.in.mapper.CreditOpenCommandMapper;
import com.github.bifrurcated.credit.infrastructure.micronaut.in.mapper.CreditOpenResponseMapper;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

@Validated
@Controller("/credit")
public class CreditRestController implements CreditRestApi {

    private final CreditOpeningService creditOpeningService;
    private final CreditOpenCommandMapper creditOpenCommandMapper;
    private final CreditOpenResponseMapper creditOpenResponseMapper;

    @Inject
    public CreditRestController(CreditOpeningService creditOpeningService,
                                CreditOpenCommandMapper creditOpenCommandMapper,
                                CreditOpenResponseMapper creditOpenResponseMapper) {
        this.creditOpeningService = creditOpeningService;
        this.creditOpenCommandMapper = creditOpenCommandMapper;
        this.creditOpenResponseMapper = creditOpenResponseMapper;
    }

    @Post("/open")
    @Override
    public CreditOpenResponse open(@Body @Valid CreditOpenRequest request) {
        var creditOpenCommand = creditOpenCommandMapper.toCreditOpenCommand(request);
        var credit = creditOpeningService.open(creditOpenCommand);
        return creditOpenResponseMapper.toCreditOpenResponse(credit);
    }
}