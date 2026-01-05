package com.github.bifrurcated.credit.infrastructure.quarkus.out;

import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.domain.spi.CreditRepository;
import com.github.bifrurcated.credit.infrastructure.persistence.jpa.repository.CreditEntityRepository;
import com.github.bifrurcated.credit.infrastructure.quarkus.out.mapper.CreditEntityMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.NonNull;

import java.time.Clock;
import java.time.LocalDateTime;

@ApplicationScoped
public class JpaCreditRepository implements CreditRepository {

    private final CreditEntityRepository creditEntityRepository;

    private final CreditEntityMapper creditEntityMapper;

    private final Clock clock;

    public JpaCreditRepository(CreditEntityRepository creditEntityRepository,
                               CreditEntityMapper creditEntityMapper,
                               Clock clock) {
        this.creditEntityRepository = creditEntityRepository;
        this.creditEntityMapper = creditEntityMapper;
        this.clock = clock;
    }

    @Transactional
    @Override
    public void save(@NonNull Credit credit) {
        var currentDateTime = LocalDateTime.now(clock);
        var creditEntity = creditEntityMapper.toCreditEntity(credit, currentDateTime);
        creditEntityRepository.insert(creditEntity);
    }
}
