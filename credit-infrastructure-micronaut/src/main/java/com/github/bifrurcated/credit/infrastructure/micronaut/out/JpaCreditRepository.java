package com.github.bifrurcated.credit.infrastructure.micronaut.out;

import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.domain.spi.CreditRepository;
import com.github.bifrurcated.credit.infrastructure.micronaut.out.mapper.CreditEntityMapper;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import org.jspecify.annotations.NonNull;

@Singleton
public class JpaCreditRepository implements CreditRepository {

    private final CreditEntityJpaRepository creditEntityJpaRepository;
    private final CreditEntityMapper creditEntityMapper;

    public JpaCreditRepository(CreditEntityJpaRepository creditEntityJpaRepository,
                               CreditEntityMapper creditEntityMapper) {
        this.creditEntityJpaRepository = creditEntityJpaRepository;
        this.creditEntityMapper = creditEntityMapper;
    }

    @Transactional
    @Override
    public void save(@NonNull Credit credit) {
        var creditEntity = creditEntityMapper.toCreditEntity(credit);
        creditEntityJpaRepository.save(creditEntity);
    }
}
