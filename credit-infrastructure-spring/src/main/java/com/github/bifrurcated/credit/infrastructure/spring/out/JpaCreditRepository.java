package com.github.bifrurcated.credit.infrastructure.spring.out;

import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.domain.spi.CreditRepository;
import com.github.bifrurcated.credit.infrastructure.persistence.jpa.repository.CreditEntityJpaRepository;
import com.github.bifrurcated.credit.infrastructure.spring.out.mapper.CreditEntityMapper;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
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
