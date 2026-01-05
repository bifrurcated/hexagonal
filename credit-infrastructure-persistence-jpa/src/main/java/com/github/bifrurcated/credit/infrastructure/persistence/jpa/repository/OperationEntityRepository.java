package com.github.bifrurcated.credit.infrastructure.persistence.jpa.repository;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.OperationEntity;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.UUID;

@Repository
public interface OperationEntityRepository extends CrudRepository<OperationEntity, UUID> {
}
