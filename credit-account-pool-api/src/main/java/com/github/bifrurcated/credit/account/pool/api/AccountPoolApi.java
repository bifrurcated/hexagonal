package com.github.bifrurcated.credit.account.pool.api;

import com.github.bifrurcated.credit.account.pool.api.dto.request.NextAccountPoolRequest;
import com.github.bifrurcated.credit.account.pool.api.dto.response.NextAccountPoolResponse;

public interface AccountPoolApi {

    NextAccountPoolResponse next(NextAccountPoolRequest request);
}
