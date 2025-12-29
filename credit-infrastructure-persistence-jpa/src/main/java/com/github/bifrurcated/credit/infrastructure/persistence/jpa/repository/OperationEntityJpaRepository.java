package com.github.bifrurcated.credit.infrastructure.persistence.jpa.repository;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationEntityJpaRepository extends JpaRepository<OperationEntity, UUID> {
}
