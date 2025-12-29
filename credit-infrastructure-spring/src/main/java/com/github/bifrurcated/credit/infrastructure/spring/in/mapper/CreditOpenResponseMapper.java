package com.github.bifrurcated.credit.infrastructure.spring.in.mapper;

import com.github.bifrurcated.credit.api.rest.dto.response.CreditOpenResponse;
import com.github.bifrurcated.credit.domain.model.Credit;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CreditOpenResponseMapper {

    CreditOpenResponse toCreditOpenResponse(Credit credit);
}
