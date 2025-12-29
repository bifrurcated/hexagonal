package com.github.bifrurcated.credit.infrastructure.quarkus.in.mapper;

import com.github.bifrurcated.credit.api.rest.dto.request.CreditOpenRequest;
import com.github.bifrurcated.credit.domain.service.command.CreditOpenCommand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CreditOpenCommandMapper {

    CreditOpenCommand toCreditOpenCommand(CreditOpenRequest creditOpenRequest);
}
