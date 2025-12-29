package com.github.bifrurcated.credit.infrastructure.persistence.jpa.repository;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreditEntityJpaRepository extends JpaRepository<CreditEntity, UUID> {
}
