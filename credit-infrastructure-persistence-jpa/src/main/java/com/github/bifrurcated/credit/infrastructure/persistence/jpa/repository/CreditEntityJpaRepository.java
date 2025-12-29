package com.github.bifrurcated.credit.infrastructure.persistence.jpa.repository;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditEntityJpaRepository extends JpaRepository<CreditEntity, UUID> {
}
