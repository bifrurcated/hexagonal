package com.github.bifrurcated.credit.infrastructure.quarkus.in.mapper;

import com.github.bifrurcated.credit.api.rest.dto.response.CreditOpenResponse;
import com.github.bifrurcated.credit.domain.model.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CreditOpenResponseMapper {

    CreditOpenResponse toCreditOpenResponse(Credit credit);
}
