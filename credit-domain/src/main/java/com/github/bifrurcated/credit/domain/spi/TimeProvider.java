package com.github.bifrurcated.credit.domain.spi;

import java.time.LocalDate;

public interface TimeProvider {

    LocalDate currentDate();
}
