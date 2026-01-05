package com.github.bifrurcated.credit.infrastructure.persistence.jpa.repository;

import com.github.bifrurcated.credit.infrastructure.persistence.jpa.entity.CreditEntity;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.UUID;

@Repository
public interface CreditEntityRepository extends CrudRepository<CreditEntity, UUID> {
}
