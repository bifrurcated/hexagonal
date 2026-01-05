package com.github.bifrurcated.credit.infrastructure.quarkus.out;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreditEntityRepository extends JpaRepository<CreditEntity, UUID> {
}
