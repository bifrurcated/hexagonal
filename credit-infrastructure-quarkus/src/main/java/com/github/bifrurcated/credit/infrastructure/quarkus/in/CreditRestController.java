package com.github.bifrurcated.credit.infrastructure.quarkus.in;

import com.github.bifrurcated.credit.api.rest.CreditRestApi;
import com.github.bifrurcated.credit.api.rest.dto.request.CreditOpenRequest;
import com.github.bifrurcated.credit.api.rest.dto.response.CreditOpenResponse;
import com.github.bifrurcated.credit.domain.service.CreditOpeningService;
import com.github.bifrurcated.credit.infrastructure.quarkus.in.mapper.CreditOpenCommandMapper;
import com.github.bifrurcated.credit.infrastructure.quarkus.in.mapper.CreditOpenResponseMapper;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/credit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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

    @POST
    @Path("/open")
    @Override
    public CreditOpenResponse open(@Valid CreditOpenRequest request) {
        var creditOpenCommand = creditOpenCommandMapper.toCreditOpenCommand(request);
        var credit = creditOpeningService.open(creditOpenCommand);
        return creditOpenResponseMapper.toCreditOpenResponse(credit);
    }
}
