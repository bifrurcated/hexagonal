package com.github.bifrurcated.credit.infrastructure.micronaut.out;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface CreditEntityJpaRepository extends JpaRepository<CreditEntity, UUID> {
}
