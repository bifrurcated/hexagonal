package com.github.bifrurcated.credit.infrastructure.spring.out;

import com.github.bifrurcated.credit.account.pool.api.dto.request.AccountType;
import com.github.bifrurcated.credit.account.pool.api.dto.request.NextAccountPoolRequest;
import com.github.bifrurcated.credit.account.pool.api.exception.CreditAccountPoolEmptyException;
import com.github.bifrurcated.credit.domain.spi.CreditAccountPool;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@ConditionalOnProperty(value = "account-pool.rest-client.enabled")
@Primary
@Service
public class CreditAccountPoolRestClient implements CreditAccountPool {

    private final AccountPoolRestClient accountPoolRestClient;

    public CreditAccountPoolRestClient(AccountPoolRestClient accountPoolRestClient) {
        this.accountPoolRestClient = accountPoolRestClient;
    }

    @NonNull
    @Override
    public String getAccountNumber() {
        var nextAccountPoolRequest = new NextAccountPoolRequest(AccountType.CREDIT, 1);
        var nextAccountPoolResponse = accountPoolRestClient.next(nextAccountPoolRequest);
        if (nextAccountPoolResponse.accounts().isEmpty()) {
            throw new CreditAccountPoolEmptyException();
        }
        var accountPoolInfo = nextAccountPoolResponse.accounts().getFirst();
        return accountPoolInfo.number();
    }
}
