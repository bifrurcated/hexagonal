package com.github.bifrurcated.credit.domain.model.valueobject.exception;

public class CreditExpirationDateIsBeforeCurrentDateException extends ValueObjectDomainException {

    public CreditExpirationDateIsBeforeCurrentDateException() {
        super("Дата окончания должна быть в будущем.");
    }
}
