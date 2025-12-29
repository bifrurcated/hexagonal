package com.github.bifrurcated.credit.infrastructure.spring.in.mapper;

import com.github.bifrurcated.credit.api.rest.dto.request.CreditOpenRequest;
import com.github.bifrurcated.credit.domain.service.command.CreditOpenCommand;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CreditOpenCommandMapper {

    CreditOpenCommand toCreditOpenCommand(CreditOpenRequest creditOpenRequest);
}
