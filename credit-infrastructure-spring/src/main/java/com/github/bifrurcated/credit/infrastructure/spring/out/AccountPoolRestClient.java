package com.github.bifrurcated.credit.infrastructure.spring.out;

import com.github.bifrurcated.credit.account.pool.api.AccountPoolApi;
import com.github.bifrurcated.credit.account.pool.api.dto.request.NextAccountPoolRequest;
import com.github.bifrurcated.credit.account.pool.api.dto.response.NextAccountPoolResponse;
import org.springframework.http.MediaType;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "http://account-pool/accounts", contentType = MediaType.APPLICATION_JSON_VALUE)
public interface AccountPoolRestClient extends AccountPoolApi {

    @Retryable(maxRetries = 3, timeout = 1000L)
    @PostExchange("/next")
    @Override
    NextAccountPoolResponse next(@RequestBody NextAccountPoolRequest request);
}
