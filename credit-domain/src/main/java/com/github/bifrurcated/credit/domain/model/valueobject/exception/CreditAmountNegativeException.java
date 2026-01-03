package com.github.bifrurcated.credit.domain.model.valueobject.exception;

public class CreditAmountNegativeException extends ValueObjectDomainException {

    public CreditAmountNegativeException() {
        super("Сумма должна быть неотрицательной");
    }
}
