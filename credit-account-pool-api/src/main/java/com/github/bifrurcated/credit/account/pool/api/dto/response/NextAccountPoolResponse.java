package com.github.bifrurcated.credit.account.pool.api.dto.response;

import java.util.List;

public record NextAccountPoolResponse(List<AccountPoolInfo> accounts) {

    public record AccountPoolInfo(String accountId, String number) {

    }
}
