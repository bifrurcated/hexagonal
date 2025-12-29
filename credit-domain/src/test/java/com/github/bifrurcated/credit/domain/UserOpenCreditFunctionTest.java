package com.github.bifrurcated.credit.domain;

import com.github.bifrurcated.credit.domain.service.command.CreditOpenCommand;
import com.github.bifrurcated.credit.domain.model.Credit;
import com.github.bifrurcated.credit.domain.model.CreditStatus;
import com.github.bifrurcated.credit.domain.model.valueobject.CreditAmount;
import com.github.bifrurcated.credit.domain.model.valueobject.CreditExpirationDateFactory;
import com.github.bifrurcated.credit.domain.service.CreditOpeningService;
import com.github.bifrurcated.credit.domain.spi.stubs.CreditAccountPoolStub;
import com.github.bifrurcated.credit.domain.spi.stubs.CreditRepositoryStub;
import com.github.bifrurcated.credit.domain.spi.stubs.IdGeneratorStub;
import com.github.bifrurcated.credit.domain.spi.stubs.TimeProviderStub;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UserOpenCreditFunctionTest {

    @Test
    void should_user_open_credit() {
        var userId = UUID.randomUUID();
        var amount = new BigDecimal(1_000_000);
        var expirationDate = LocalDate.of(2026, Month.JANUARY, 27);
        var timeProvider = new TimeProviderStub();
        var creditExpirationDateFactory = new CreditExpirationDateFactory(timeProvider);
        CreditOpeningService creditOpeningService = new CreditOpeningService(
                timeProvider,
                new CreditAccountPoolStub(),
                new CreditRepositoryStub(),
                new IdGeneratorStub()
        );

        Credit credit = creditOpeningService.open(new CreditOpenCommand(userId, amount, expirationDate));

        assertThat(credit)
                .returns(UUID.fromString("c76ab6cf-d892-4ca8-97ba-6ce55965ada9"), Credit::id)
                .returns(new CreditAmount(amount), Credit::amount)
                .returns(userId, Credit::userId)
                .returns(CreditStatus.ACTIVE, Credit::status)
                .returns(List.of(), Credit::operations)
                .returns(creditExpirationDateFactory.create(expirationDate), Credit::expirationDate)
                .returns("1234567890", Credit::number);
    }
}
