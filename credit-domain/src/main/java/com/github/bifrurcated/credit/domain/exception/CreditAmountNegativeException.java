package com.github.bifrurcated.credit.domain.exception;

public class CreditAmountNegativeException extends DomainException {

    public CreditAmountNegativeException() {
        super("Сумма должна быть неотрицательной");
    }
}
