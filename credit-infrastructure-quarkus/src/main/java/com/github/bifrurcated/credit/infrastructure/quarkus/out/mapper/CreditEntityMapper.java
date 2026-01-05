package com.github.bifrurcated.credit.infrastructure.quarkus.out.mapper;

import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CreditEntityMapper {

    @Mapping(target = "id", source = "credit.id")
    @Mapping(target = "userId", source = "credit.userId")
    @Mapping(target = "status", source = "credit.status")
    @Mapping(target = "amount", source = "credit.amount.value")
    @Mapping(target = "number", source = "credit.number")
    @Mapping(target = "expirationDate", expression = "java(credit.expirationDate().value())")
    @Mapping(target = "operations", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    CreditEntity toCreditEntity(Credit credit);
}
