package com.github.bifrurcated.credit.domain.model.valueobject;

import com.github.bifrurcated.credit.domain.model.valueobject.exception.CreditExpirationDateIsBeforeCurrentDateException;
import com.github.bifrurcated.credit.domain.spi.TimeProvider;
import org.jspecify.annotations.NonNull;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Фабрика для создания правильного ValueObject класса {@link CreditExpirationDate}.
 */
public class CreditExpirationDateFactory {

    private final @NonNull TimeProvider timeProvider;

    public CreditExpirationDateFactory(@NonNull TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public @NonNull CreditExpirationDate create(@NonNull LocalDate expirationDate) {
        if (expirationDate.isBefore(timeProvider.currentDate())) {
            throw new CreditExpirationDateIsBeforeCurrentDateException();
        }
        return new CreditExpirationDate(expirationDate);
    }

    /**
     * На прямую данный класс создать нельзя, для создания правильного экземпляра {@link CreditExpirationDate}
     * воспользуйтесь фабричным методом {@link CreditExpirationDateFactory#create(LocalDate)}
     */
    public static final class CreditExpirationDate {

        private final @NonNull LocalDate value;

        private CreditExpirationDate(@NonNull LocalDate value) {
            this.value = value;
        }

        public @NonNull LocalDate value() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof CreditExpirationDate that)) return false;
            return Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
