package com.github.bifrurcated.credit.domain.service;

import com.github.bifrurcated.credit.domain.service.command.CreditOpenCommand;
import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.domain.model.valueobject.CreditAmount;
import com.github.bifrurcated.credit.domain.model.valueobject.CreditExpirationDateFactory;
import com.github.bifrurcated.credit.domain.spi.CreditAccountPool;
import com.github.bifrurcated.credit.domain.spi.CreditRepository;
import com.github.bifrurcated.credit.domain.spi.IdGenerator;
import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import org.jspecify.annotations.NonNull;

@DomainService
public class CreditOpeningService {

    private final CreditExpirationDateFactory creditExpirationDateFactory;

    private final CreditAccountPool creditAccountPool;

    private final CreditRepository creditRepository;

    private final IdGenerator idGenerator;

    public CreditOpeningService(TimeProvider timeProvider, CreditAccountPool creditAccountPool, CreditRepository creditRepository, IdGenerator idGenerator) {
        this.creditExpirationDateFactory = new CreditExpirationDateFactory(timeProvider);
        this.creditAccountPool = creditAccountPool;
        this.creditRepository = creditRepository;
        this.idGenerator = idGenerator;
    }

    public @NonNull Credit open(@NonNull CreditOpenCommand creditOpenCommand) {
        var creditAmount = new CreditAmount(creditOpenCommand.amount());
        var creditExpirationDate = creditExpirationDateFactory.create(creditOpenCommand.expirationDate());
        var number = creditAccountPool.getAccountNumber();
        var creditId = idGenerator.generateUUID();
        var credit = new Credit(creditId, creditOpenCommand.userId(), creditAmount, number, creditExpirationDate);
        creditRepository.save(credit);
        return credit;
    }
}
