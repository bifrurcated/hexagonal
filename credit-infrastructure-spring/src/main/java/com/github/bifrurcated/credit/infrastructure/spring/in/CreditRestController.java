package com.github.bifrurcated.credit.infrastructure.spring.in;

import com.github.bifrurcated.credit.api.rest.CreditRestApi;
import com.github.bifrurcated.credit.api.rest.dto.request.CreditOpenRequest;
import com.github.bifrurcated.credit.api.rest.dto.response.CreditOpenResponse;
import com.github.bifrurcated.credit.domain.service.CreditOpeningService;
import com.github.bifrurcated.credit.infrastructure.spring.in.mapper.CreditOpenCommandMapper;
import com.github.bifrurcated.credit.infrastructure.spring.in.mapper.CreditOpenResponseMapper;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/credit")
public class CreditRestController implements CreditRestApi {

    private final CreditOpeningService creditOpeningService;

    private final CreditOpenCommandMapper creditOpenCommandMapper;

    private final CreditOpenResponseMapper creditOpenResponseMapper;

    public CreditRestController(CreditOpeningService creditOpeningService,
                                CreditOpenCommandMapper creditOpenCommandMapper,
                                CreditOpenResponseMapper creditOpenResponseMapper) {
        this.creditOpeningService = creditOpeningService;
        this.creditOpenCommandMapper = creditOpenCommandMapper;
        this.creditOpenResponseMapper = creditOpenResponseMapper;
    }

    @PostMapping("/open")
    public CreditOpenResponse open(@RequestBody @Valid CreditOpenRequest request) {
        var creditOpenCommand = creditOpenCommandMapper.toCreditOpenCommand(request);
        var credit = creditOpeningService.open(creditOpenCommand);
        return creditOpenResponseMapper.toCreditOpenResponse(credit);
    }
}
