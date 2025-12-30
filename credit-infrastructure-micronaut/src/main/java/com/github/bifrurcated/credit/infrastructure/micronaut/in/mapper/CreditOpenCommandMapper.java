package com.github.bifrurcated.credit.infrastructure.micronaut.in.mapper;

import com.github.bifrurcated.credit.api.rest.dto.request.CreditOpenRequest;
import com.github.bifrurcated.credit.domain.service.command.CreditOpenCommand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JSR330)
public interface CreditOpenCommandMapper {

    CreditOpenCommand toCreditOpenCommand(CreditOpenRequest creditOpenRequest);
}
