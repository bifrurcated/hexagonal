package com.github.bifrurcated.credit.domain.exception;

public class CreditExpirationDateIsBeforeCurrentDateException extends DomainException {

    public CreditExpirationDateIsBeforeCurrentDateException() {
        super("Дата окончания должна быть в будущем.");
    }
}
