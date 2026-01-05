package com.github.bifrurcated.credit.infrastructure.quarkus.out;

import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.domain.spi.CreditRepository;
import com.github.bifrurcated.credit.infrastructure.quarkus.out.mapper.CreditEntityMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.NonNull;

@ApplicationScoped
public class JpaCreditRepository implements CreditRepository {

    private final CreditEntityRepository creditEntityRepository;

    private final CreditEntityMapper creditEntityMapper;

    public JpaCreditRepository(CreditEntityRepository creditEntityRepository,
                               CreditEntityMapper creditEntityMapper) {
        this.creditEntityRepository = creditEntityRepository;
        this.creditEntityMapper = creditEntityMapper;
    }

    @Transactional
    @Override
    public void save(@NonNull Credit credit) {
        var creditEntity = creditEntityMapper.toCreditEntity(credit);
        creditEntityRepository.save(creditEntity);
    }
}
