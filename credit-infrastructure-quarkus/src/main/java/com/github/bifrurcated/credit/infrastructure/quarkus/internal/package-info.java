///
///  Реализации портов, использующие только JVM:
/// * Генераторы ID (UUID, Snowflake)
/// * Провайдеры времени (System.currentTimeMillis())
/// * Простые in-memory реализации для тестов
/// * Хэш-функции, шифрование (если без внешних сервисов)
///
package com.github.bifrurcated.credit.infrastructure.quarkus.internal;