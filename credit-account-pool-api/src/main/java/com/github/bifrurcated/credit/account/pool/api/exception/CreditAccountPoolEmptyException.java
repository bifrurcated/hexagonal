package com.github.bifrurcated.credit.account.pool.api.exception;

public class CreditAccountPoolEmptyException extends RuntimeException {
    public CreditAccountPoolEmptyException() {
        super("Кредитный пулл счетов пуст.");
    }
}
