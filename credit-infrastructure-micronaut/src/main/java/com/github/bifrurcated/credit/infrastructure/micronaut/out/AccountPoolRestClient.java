package com.github.bifrurcated.credit.infrastructure.micronaut.out;

import com.github.bifrurcated.credit.account.pool.api.AccountPoolApi;
import com.github.bifrurcated.credit.account.pool.api.dto.request.NextAccountPoolRequest;
import com.github.bifrurcated.credit.account.pool.api.dto.response.NextAccountPoolResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;

@Client("${account-pool.base-url}/accounts")
public interface AccountPoolRestClient extends AccountPoolApi {

    @Post("/next")
    @Override
    NextAccountPoolResponse next(@Body @Valid NextAccountPoolRequest request);
}
