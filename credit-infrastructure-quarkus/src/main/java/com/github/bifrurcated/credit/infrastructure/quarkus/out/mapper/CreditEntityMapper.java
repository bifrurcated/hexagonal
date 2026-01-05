package com.github.bifrurcated.credit.infrastructure.quarkus.out.mapper;

import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDateTime;

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
    @Mapping(target = "updateTime", source = "currentDateTime")
    @Mapping(target = "createTime", source = "currentDateTime")
    CreditEntity toCreditEntity(Credit credit, LocalDateTime currentDateTime);
}
