package com.github.bifrurcated.credit.infrastructure.spring.out.mapper;

import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CreditEntityMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "amount", source = "amount.value")
    @Mapping(target = "number", source = "number")
    @Mapping(target = "expirationDate", expression = "java(credit.expirationDate().value())")
    @Mapping(target = "operations", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    CreditEntity toCreditEntity(Credit credit);
}
