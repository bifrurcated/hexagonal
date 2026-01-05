package com.github.bifrurcated.credit.infrastructure.spring.out;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditEntityRepository extends JpaRepository<CreditEntity, UUID> {
}
